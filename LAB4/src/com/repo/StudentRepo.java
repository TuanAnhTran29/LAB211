package com.repo;

import com.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo, Serializable{
    private static StudentRepo studentRepo;
    private static final File file= new File("student.txt");

    public static StudentRepo getInstance(){
        if (studentRepo == null){
            return new StudentRepo();
        }
        return studentRepo;
    }
    @Override
    public List<Student> readFile() throws IOException {
        List<Student> studentList= new ArrayList<>();
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() == 0){
            return new ArrayList<>();
        }

        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            studentList= (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void writeFile(List<Student> t) throws IOException, ClassNotFoundException {
        try {
            OutputStream outputStream= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(t);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
