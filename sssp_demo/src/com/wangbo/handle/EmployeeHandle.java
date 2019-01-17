package com.wangbo.handle;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import com.wangbo.entity.Employee;
import com.wangbo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emps")
public class EmployeeHandle {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
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


}
