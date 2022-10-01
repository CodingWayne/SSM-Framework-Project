package com.wayne.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.wayne.ssm.pojo.Employee;
import com.wayne.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author JIA-YANG, LAI
 * @create 2022-10-01 下午 02:32
 *  * 查詢所有的員工資訊-->/employee--<get
 *  * 查詢所有的員工資訊(分頁)-->/employee/page/1--<get  1為頁碼
 *  * 根據id查詢員工資訊-->/employee/1--<get
 *  * 增加員工資訊-->/employee--<post
 *  * 跳轉到添加頁面-->/to/add--<get
 *  * 修改員工資訊-->/employee--<put
 *  * 刪除員工資訊-->/employee--<delete
 */
@Controller
public class EmployeeControler {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查詢所有的員工資訊
        List<Employee> allEmployee =employeeService.getAllEmployee();
        System.out.println(allEmployee);
        //查詢完後共享到域對象中
        model.addAttribute("list",allEmployee);
        //跳轉到employee_Lise.html
        return "employee_list";

    }

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        //獲取員工的分頁資訊
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //將分頁數據共享到請求域中
        model.addAttribute("page",page);
        int num = employeeService.getNum();
        model.addAttribute("num",num);

        return "employee_list";

    }
    @RequestMapping(value = "/employee/page/{pageNum}/{empId}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("pageNum") Integer pageNum,@PathVariable("empId") Integer empId,Model model){
        //獲取當前頁的分頁資訊
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //根據ID獲取員工的資訊
        Employee employee = employeeService.getEmployeeById(empId);
        System.out.println(employee);
        //將該員工共享到請求域
        model.addAttribute("Employee",employee);
        //將分頁數據共享到請求域中
        model.addAttribute("page",page);

        return "employee_update";

    }
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.PUT)
    public String updateEmployeeById(@PathVariable("pageNum") Integer pageNum,Employee employee){
        System.out.println(employee);
        //修改員工資訊
        employeeService.save(employee);
        //重定向到列表
        String rt = "redirect:/employee/page/" + pageNum;
        return rt;
    }

    @RequestMapping(value = "/employee/page/{pageNum}/{empId}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("pageNum") Integer pageNum,@PathVariable("empId") Integer empId){
        System.out.println(empId);
        //修改員工資訊
        employeeService.deleteEmployeeById(empId);
        //重定向到列表
        String rt = "redirect:/employee/page/" + pageNum;
        return rt;
    }

    @RequestMapping(value = "/employee/page/to/last",method = RequestMethod.POST)
    public String insertEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        PageInfo<Employee> page = employeeService.getEmployeePage();
        String lastPage = String.valueOf(page.getPages());
        String rt = "redirect:/employee/page/" + lastPage;
        return rt;


    }



}
