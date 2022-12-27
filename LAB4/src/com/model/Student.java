package com.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;
    private String name;
    private String semester;
    private String courseName;
    private int numOfCourse;

    public Student(Long id, String name,String semester, String courseName,int numOfCourse) {
        this.id = id;
        this.name = name;
        this.semester= semester;
        this.courseName = courseName;
        this.numOfCourse= numOfCourse;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumOfCourse() {
        return numOfCourse;
    }

    public void setNumOfCourse(int numOfCourse) {
        this.numOfCourse = numOfCourse;
    }

    @Override
    public String toString() {
        return  name + " | " + courseName + " | " + numOfCourse;
    }
}
