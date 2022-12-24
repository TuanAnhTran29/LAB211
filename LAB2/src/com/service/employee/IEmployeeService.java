package com.service.employee;

import com.model.Employee;
import com.service.IGeneralService;

public interface IEmployeeService extends IGeneralService<Employee> {
    Employee findByIdAndPassword(String id, String password);
}
