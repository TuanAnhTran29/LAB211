package com.view;

import com.controller.StudentController;
import com.model.Student;

import java.util.Scanner;

public class MainFunction {
    private static StudentController studentController= new StudentController();
    private static Scanner scanner= new Scanner(System.in);

    public static void create() {
        boolean next= true;
        while (next){
            System.out.print("Enter ID: ");
            Long id= Long.parseLong(scanner.nextLine());
            System.out.print("Enter student name: ");
            String name= scanner.nextLine();
            System.out.print("Enter semester: ");
            String semester= scanner.nextLine();
            System.out.print("Enter course name: ");
            String courseName= scanner.nextLine();
            System.out.print("Enter number of course: ");
            int numOfCourse= Integer.parseInt(scanner.nextLine());

            studentController.add(new Student(id,name,semester,courseName,numOfCourse));
            System.out.println("Created successfully!");

            System.out.print("Do you want to add more? Y/N: ");
            String choice= scanner.nextLine();
            next= choice.equals("Y") || choice.equals("y");
        }

    }

    public static void findAndSort(){
        System.out.print("Enter student name: ");
        String name= scanner.nextLine();
        if (studentController.findByName(name).isEmpty()){
            System.out.println("Student does not exist");
        }else {
            for (int i = 0; i < studentController.findByName(name).size(); i++) {
                Student student= studentController.findByName(name).get(i);
                System.out.println(student.getName() + " | " + student.getSemester() + " | " + student.getCourseName());
            }
        }
    }

    public static void updateAndDelete() {
        System.out.println("Enter student ID: ");
        Long id= Long.parseLong(scanner.nextLine());
        Student student= studentController.findById(id);
        if (student== null){
            System.out.println("Student does not exist");
        }else {
            System.out.println("Do you want to update (U) or delete (D)");
            String choice= scanner.nextLine();
            if (choice.equals("U")){
                System.out.print("Enter new ID: ");
                Long newId= Long.parseLong(scanner.nextLine());
                System.out.print("Enter new student name: ");
                String name= scanner.nextLine();
                System.out.print("Enter new semester: ");
                String semester= scanner.nextLine();
                System.out.print("Enter new course name: ");
                String courseName= scanner.nextLine();
                System.out.print("Enter new number of course: ");
                int numOfCourse= Integer.parseInt(scanner.nextLine());

                student.setId(newId);
                student.setName(name);
                student.setSemester(semester);
                student.setCourseName(courseName);
                student.setNumOfCourse(numOfCourse);

                studentController.update(student);
                System.out.println("Updated success");
            }else {
                studentController.delete(student);
                System.out.println("Deleted success");
            }
        }
    }

    public static void report() {
        for (Student s : studentController.findAll()) {
            System.out.println(s);
        }
    }
}
