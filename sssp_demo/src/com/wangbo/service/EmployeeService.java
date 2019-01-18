package com.wangbo.service;

import com.wangbo.entity.Employee;
import com.wangbo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Service
public class EmployeeService  {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getPage(int pageNo ,int pageSize){
        PageRequest pageable = new PageRequest(pageNo - 1, pageSize);
        return employeeRepository.findAll(pageable);
    }

    @Transactional(readOnly = false)
    public void save(Employee employee){
        employee.setCreateTime(new Date());
         employeeRepository.saveAndFlush(employee);
    }

    @Transactional(readOnly = false)
    public Employee checkLastName(String lastName){
        return employeeRepository.getByLastName(lastName);
    }
}
