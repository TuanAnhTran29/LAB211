package com.repo.employee;

import com.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo, Serializable{
    private static final File file= new File("employee.dat");
    private static EmployeeRepo employeeRepo= null;

    public static EmployeeRepo getInstance(){
        if (employeeRepo== null){
            return new EmployeeRepo();
        }
        return employeeRepo;
    }
    @Override
    public List<Employee> readFile() throws IOException {
        List<Employee> employeeList= new ArrayList<>();
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() == 0){
            return new ArrayList<>();
        }
        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            employeeList= (List<Employee>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void writeFile(List<Employee> employeeList) throws IOException, ClassNotFoundException {
        try {
            OutputStream outputStream= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(employeeList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
