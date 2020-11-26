<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leave Add Page</title>
</head>
<body>
<div class="modal fade leave-add-modal" tabindex="-1" role="dialog" aria-labelledby="leave-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">申请假条</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_leave_form">
                    <div class="form-group">
                        <label for="add_inputName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="ename" class="form-control" id="add_inputName" placeholder="如：张三">
                            <span id="helpBlock_add_inputName" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_inputEmail" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="dno" class="form-control" id="add_inputEmail" >
                            <span id="helpBlock_add_inputEmail" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">请假日期</label>
                        <div class="col-sm-8">
                                <input type="date" checked="checked" name="date" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">请假原因</label>
                        <div class="col-sm-8">
                            <input type="text" name="reason">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary leave_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

    $(".leave_add_btn").click(function () {
        $('.leave-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });


    $(".leave_save_btn").click(function () {

        if($(".leave_save_btn").attr("btn_name_exists") == "error"){
            return false;
        }

        $.ajax({
            url:"/hrms/leave/addLeave",
            type:"POST",
            data:$(".add_leave_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("假条新增成功");
                    $('#leave-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/hrms/leave/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/hrms/leave/getLeaveList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("假条新增失败！");
                }
            }

        });





    });



</script>
</body>
</html>
