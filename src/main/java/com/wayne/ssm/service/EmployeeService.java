package com.wayne.ssm.service;

import com.github.pagehelper.PageInfo;
import com.wayne.ssm.pojo.Employee;

import java.util.List;

/**
 * @author JIA-YANG, LAI
 * @create 2022-10-01 下午 02:47
 */
public interface EmployeeService {
    /**
     * 獲取員工的分頁資訊
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
    PageInfo<Employee> getEmployeePage();

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer empId);

    void save(Employee employee);

    void deleteEmployeeById(Integer empId);

    void insertEmployee(Employee employee);

    int getNum();
}
