package com.wayne.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.ssm.mapper.EmployeeMapper;
import com.wayne.ssm.pojo.Employee;
import com.wayne.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JIA-YANG, LAI
 * @create 2022-10-01 下午 02:47
 * 查詢所有的員工資訊-->/employee--<get
 * 根據id查詢員工資訊-->/employee/1--<get
 * 增加員工資訊-->/employee--<post
 * 跳轉到添加頁面-->/to/add--<get
 * 修改員工資訊-->/employee--<put
 * 刪除員工資訊-->/employee--<delete
 *
 */
@Service
@Transactional
public class EployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //開啟分頁功能
        PageHelper.startPage(pageNum,10);
        //查詢所有的員工資訊, pagehelper會對接下來要執行的sql進行攔截，也就是加上limit
        List<Employee> list = employeeMapper.getAllEmployee();
        //獲取分頁相關數據
        PageInfo<Employee> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public PageInfo<Employee> getEmployeePage() {
        //開啟分頁功能
        PageHelper.startPage(0,10);
        //查詢所有的員工資訊, pagehelper會對接下來要執行的sql進行攔截，也就是加上limit
        List<Employee> list = employeeMapper.getAllEmployee();
        //獲取分頁相關數據
        PageInfo<Employee> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {

        return employeeMapper.getEmployeeById(empId);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        employeeMapper.deleteEmployeeById(empId);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public int getNum() {
        return employeeMapper.getNum();
    }
}
