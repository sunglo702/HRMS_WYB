package com.hrms.mapper;

import com.hrms.bean.Employee;
import com.hrms.bean.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/11/25 13:11
 */
public interface LeaveMapper {
    String TABLE_NAME = "attend";
    String INSERT_FIELDS = "ename,dno,adate,leave_reason";
    /**
     * 分页查询
     * @param limit 返回记录最大行数
     * @param offset 返回记录行的偏移量
     * @return 如offset=10，limit=5的时候，就会从数据库第11行记录开始返回5条查询结果，即范围从(offset+1)---(offset+limit)
     */
    List<Leave> selectByLimitAndOffset(@Param("offset") Integer offset,
                                          @Param("limit") Integer limit);

    /**
     * 查询总记录数
     * @return
     */
    @Select({"select count(*) from", TABLE_NAME})
    int countLeaves();

    /**
     * =================================新增============================================
     */
    @Insert({"INSERT INTO", TABLE_NAME, "(",INSERT_FIELDS,") " +
            "VALUES(#{ename}, " +
            "#{dno}, " +
            "#{date}, " +
            "#{reason})"})
    int insertOne(Leave leave);


}