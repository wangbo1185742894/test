package com.wangbo.handle;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import com.wangbo.entity.Employee;
import com.wangbo.service.DepartmentService;
import com.wangbo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emps")
public class EmployeeHandle {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        employeeService.delete(id);
        return "redirect:/emps/list";
    }


    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false)Integer id,Map<String,Object>map){
        if (id != null){
            Employee employee = employeeService.getEmployeeById(id);
            employee.setDepartment(null);
            map.put("employee",employee  );
        }
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Integer id,Map<String,Object>map){
        map.put("departments",departmentService.getAll());
        map .put("employee",employeeService.getEmployeeById(id));
        return "input";
    }

    @RequestMapping(value = "/add/{id}" ,method = RequestMethod.PUT)
    public String update(@PathVariable("id")Integer id, Employee employee){
        employeeService.save(employee);
        return "redirect:/emps/list";
    }


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(Employee employee){
        employeeService.save(employee);
        return "redirect:/emps/list";
    }

    @RequestMapping(value = "/input")
    public String input(Map<String,Object>map){
        map.put("departments",departmentService.getAll());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(@RequestParam(value = "pageNo",required = false,defaultValue = "1")String pageNoStr,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5" )String pageSizeStr,
                        Map<String ,Object> map) {

        Integer pageNo = 1;
        Integer pageSize = 5;
        try {
            pageNo = Integer.parseInt(pageNoStr);
            if (pageNo < 1){
                pageNo = 1;
            }

            pageSize = Integer.parseInt(pageSizeStr);
            if (pageSize < 0){
                pageSize = 5;
            }

        }catch (Exception ex){

        }
        Page<Employee> list =  employeeService.getPage(pageNo,pageSize);
        map .put("employees",list);
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "/checkLastName")
    public String checkLastName(@RequestParam(value = "lastName" ,required = true )String lastName){
        Employee employee = employeeService.checkLastName(lastName);
        if (employee == null){
            return "0";
        }else{
            return "1";
        }
    }


}
