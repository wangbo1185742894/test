package com.wangbo.service;

import com.wangbo.entity.Employee;
import com.wangbo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeService  {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getPage(int pageNo ,int pageSize){
        PageRequest pageable = new PageRequest(pageNo - 1, pageSize);
        return employeeRepository.findAll(pageable);
    }
}
