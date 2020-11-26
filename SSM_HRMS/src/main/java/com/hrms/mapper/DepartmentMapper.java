package com.hrms.mapper;

import com.hrms.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hanxuefeng
 * @date 2020/11/25 13:12
 */
public interface DepartmentMapper {

    String TABLE_NAME = "dept";
    String INSERT_FIELDS = "dname, dept_leader";
    String SELECT_FIELDS = "dept_id as 'dno', " +
            "dept_name as 'dname', " +
            "dept_leader as 'dept_leader'";


    /**
     * =================================删除============================================
     */
    @Delete({"DELETE FROM", TABLE_NAME, "WHERE dno=#{deptId}"})
    int deleteDeptById(@Param("deptId") Integer deptId);

    /**
     * =================================更改============================================
     */
    int updateDeptById(@Param("deptId") Integer deptId,
                       @Param("department") Department department);

    /**
     * =================================新增============================================
     */
    @Insert({"INSERT INTO",TABLE_NAME, "(", INSERT_FIELDS ,") " +
            "VALUES(#{department.deptName}, #{department.deptLeader})" })
    int insertDept(@Param("department") Department department);

    /**
     * =================================查询============================================
     */
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dno=#{deptId}" })
    Department selectOneById(@Param("deptId") Integer deptId);
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_leader=#{deptLeader}" })
    Department selectOneByLeader(@Param("deptLeader") String deptLeader);
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dname=#{deptName}" })
    Department selectOneByName(@Param("deptName") String deptName);
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME})
    List<Department> selectDeptList();

    List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset,
                                                 @Param("limit") Integer limit);

    @Select({"SELECT COUNT(dno) FROM", TABLE_NAME,
            "WHERE dept_leader = #{deptLeader} OR dname = #{deptName}"})
    int checkDeptsExistsByNameAndleader(@Param("deptLeader") String deptLeader,
                         @Param("deptName") String deptName);

    @Select({"SELECT COUNT(*) FROM", TABLE_NAME})
    int countDepts();


}
