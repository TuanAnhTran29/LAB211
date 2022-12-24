package com.repo.request;

import com.model.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RequestRepo implements IRequestRepo, Serializable {
    private static final File file= new File("request.dat");
    private static RequestRepo requestRepo;

    public static RequestRepo getInstance(){
        if (requestRepo == null){
            return new RequestRepo();
        }
        return requestRepo;
    }

    @Override
    public List<Request> readFile() throws IOException {
        List<Request> requestList= new ArrayList<>();
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() == 0){
            return new ArrayList<>();
        }
        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            requestList= (List<Request>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return requestList;
    }

    @Override
    public void writeFile(List<Request> t) throws IOException, ClassNotFoundException {
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
