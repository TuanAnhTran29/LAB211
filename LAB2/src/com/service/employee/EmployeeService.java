package com.service.employee;

import com.model.Employee;
import com.repo.employee.EmployeeRepo;
import com.repo.employee.IEmployeeRepo;

import java.io.IOException;
import java.util.List;

public class EmployeeService  implements IEmployeeService{
    private static IEmployeeRepo employeeRepo= EmployeeRepo.getInstance();
    private List<Employee> employeeList= null;


    public EmployeeService() {
        try {
            employeeList= employeeRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
        try {
            employeeRepo.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equals(employee.getEmployeeID())){
                employeeList.set(i,employee);
                break;
            }
        }
        try {
            employeeRepo.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        employeeList.remove(employee);
        try {
            employeeRepo.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(String id) {
        Employee employee= null;
        for (Employee value : employeeList) {
            if (value.getEmployeeID().equals(id)) {
                employee = value;
                break;
            }
        }
        return employee;
    }

    @Override
    public Employee findByIdAndPassword(String id, String password){
        Employee employee= null;
        for (Employee value : employeeList) {
            if (value.getEmployeeID().equals(id)
                    && value.getPassword().equals(password)) {
                employee = value;
                break;
            }
        }
        return employee;
    }
}
