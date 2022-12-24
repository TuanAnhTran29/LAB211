package com.controller;

import com.model.Employee;
import com.model.Role;
import com.model.Sex;
import com.service.employee.EmployeeService;
import com.service.employee.IEmployeeService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class EmployeeController implements IGeneralController<Employee>{
    private static IEmployeeService employeeService;

    public EmployeeController() {
        employeeService= new EmployeeService();
    }


    public void signup(Employee employee){
        byte[] encrypt= employee.getPassword().getBytes();
        employee.setPassword(Base64.getEncoder().encodeToString(encrypt));
        employeeService.add(employee);
    }

    public Employee login(String id,String password){
        return employeeService.findByIdAndPassword(id,password);
    }

    @Override
    public void add(Employee employee) {
        employeeService.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeService.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeService.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeService.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
