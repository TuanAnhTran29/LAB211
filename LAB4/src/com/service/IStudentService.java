package com.service;

import com.model.Student;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> findByName(String name);
}
