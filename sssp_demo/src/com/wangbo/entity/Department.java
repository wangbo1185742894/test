package com.wangbo.entity;

import javax.persistence.*;

@Cacheable
@Table(name = "sssp_department")
@Entity
public class Department {

    @GeneratedValue
    @Id
    private Integer id;
    private String departmentname;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
