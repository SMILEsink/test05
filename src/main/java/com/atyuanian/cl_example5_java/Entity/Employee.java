package com.atyuanian.cl_example5_java.Entity;

import java.util.Date;

public class Employee {
    private Integer id;

    private Integer usercode;

    private String username;

//  private String department;
    private Department department;

    private java.sql.Date hiredate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public java.sql.Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(java.sql.Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", usercode=" + usercode +
                ", username='" + username + '\'' +
                ", department=" + department +
                ", hiredate=" + hiredate +
                '}';
    }
}