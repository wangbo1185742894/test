package com.wangbo.entity;

import javax.persistence.*;

@Table(name = "sssp_appble")
@Entity
public class AppAble {

    @GeneratedValue
    @Id
    private Integer id;
    private String appname;
    private String able;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAble() {
        return able;
    }

    public void setAble(String able) {
        this.able = able;
    }
}
