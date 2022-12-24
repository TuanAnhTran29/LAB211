package com.repo.borrow;

import com.model.Borrow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepo implements IBorrowRepo, Serializable {
    private static BorrowRepo borrowRepo;
    private static final File file= new File("borrow.dat");

    public static BorrowRepo getInstance(){
        if (borrowRepo== null){
            return new BorrowRepo();
        }
        return borrowRepo;
    }
    @Override
    public List<Borrow> readFile() throws IOException {
        List<Borrow> borrowList= new ArrayList<>();
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() == 0){
            return new ArrayList<>();
        }
        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            borrowList= (List<Borrow>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return borrowList;
    }

    @Override
    public void writeFile(List<Borrow> t) throws IOException, ClassNotFoundException {
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
