package com.service;

import com.model.Student;
import com.repo.IStudentRepo;
import com.repo.StudentRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService implements IStudentService{
    private static IStudentRepo studentRepo= StudentRepo.getInstance();
    private List<Student> studentList= null;

    public StudentService() {
        try {
            studentList= studentRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
        try {
            studentRepo.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (Objects.equals(studentList.get(i).getId(), student.getId())){
                studentList.set(i,student);
                break;
            }
        }
        try {
            studentRepo.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        studentList.remove(student);
        try {
            studentRepo.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(Long id) {
        Student student= null;
        for (Student value : studentList) {
            if (Objects.equals(value.getId(), id)) {
                student = value;
                break;
            }
        }
        return student;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students= new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().contains(name)) {
                students.add(student);
            }
        }
        return students;
    }
}
