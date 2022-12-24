package com.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeID;
    private String name;
    private String birthday;
    private Role role;
    private Sex sex;
    private String password;

    public Employee() {
    }

    public Employee(String employeeID, String name, String birthday, Role role, Sex sex, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public Employee(String employeeID, String name, String birthday, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.birthday = birthday;
        this.password = password;
    }

    public Employee(String name, String birthday, Role role, Sex sex, String password) {
        this.name = name;
        this.birthday = birthday;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
