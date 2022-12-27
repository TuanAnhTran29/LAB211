package com.controller;

import com.model.Student;
import com.service.IStudentService;
import com.service.StudentService;

import java.util.List;

public class StudentController {
    private static IStudentService studentService;

    public StudentController() {
        studentService= new StudentService();
    }

    public void add(Student student){
        studentService.add(student);
    }

    public List<Student> findAll(){
        return studentService.findAll();
    }

    public void update(Student student){
        studentService.update(student);
    }

    public void delete(Student student){
        studentService.delete(student);
    }

    public List<Student> findByName(String name){
        return studentService.findByName(name);
    }

    public Student findById(Long id){
        return studentService.findById(id);
    }
}
