package com.wangbo.entity;

import javax.persistence.*;
import java.util.Date;


@Table(name = "sssp_employee")
@Entity
public class Employee {



    private Integer id;
    private String lastName;
    private String email;
    private Date birth;
    private Date createTime;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Date birth, Date createTime, Department department) {
         this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
        this.createTime = createTime;
        this.department = department;
    }


    @GeneratedValue
    @Id
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @JoinColumn(name = "department_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", createTime=" + createTime +
                ", department=" + department +
                '}';
    }
}
