package com.hrms.mapper;

import com.hrms.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hanxuefeng
 * @date 2020/11/25 13:12
 */
public interface EmployeeMapper {

    String TABLE_NAME = "emp";
    String INSERT_FIELDS = "name, email, gender, dno";
    String SELECT_FIELDS = "eno, " + INSERT_FIELDS;

    /**
     * ================================= 删除 ============================================
     */
    @Delete({"DELETE FROM", TABLE_NAME, "WHERE eno = #{empId}"})
    int deleteOneById(@Param("empId") Integer empId);
    /**
     * ================================= 修改 ============================================
     */
    int updateOneById(@Param("empId") Integer empId,
                      @Param("employee") Employee employee);
    /**
     * =================================新增============================================
     */
    @Insert({"INSERT INTO", TABLE_NAME, "(",INSERT_FIELDS,") " +
                    "VALUES(#{empName}, " +
                    "#{empEmail}, " +
                    "#{gender}, " +
                    "#{departmentId})"})
    int insertOne(Employee employee);

    /**
     * =================================查询============================================
     */
    Employee selectOneById(@Param("empId") int empId);
    Employee selectOneByName(@Param("empName") String empName);
    //查询带有部门信息的Employee
    Employee selectWithDeptById(@Param("empId") Integer empId);

    /**
     * 分页查询
     * @param limit 返回记录最大行数
     * @param offset 返回记录行的偏移量
     * @return 如offset=10，limit=5的时候，就会从数据库第11行记录开始返回5条查询结果，即范围从(offset+1)---(offset+limit)
     */
    List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset,
                                          @Param("limit") Integer limit);

    /**
     * 查询总记录数
     * @return
     */
    @Select({"select count(*) from", TABLE_NAME})
    int countEmps();

}
