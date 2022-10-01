package com.wayne.ssm.mapper;

import com.wayne.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JIA-YANG, LAI
 * @create 2022-10-01 下午 02:57
 */
public interface EmployeeMapper {
    /**
     * 查詢所有的員工資訊
     * @return
     */
    List<Employee> getAllEmployee();

    Employee getEmployeeById(@Param("empId") Integer empId);

    void save(Employee employee);

    void deleteEmployeeById(@Param("empId") Integer empId);

    void insertEmployee(Employee employee);

    int getNum();
}
