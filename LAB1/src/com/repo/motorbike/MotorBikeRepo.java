package com.repo.motorbike;

import com.model.Motorbike;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MotorBikeRepo implements IMotorbikeRepo, Serializable {
    private static MotorBikeRepo motorBikeRepo;

    public MotorBikeRepo() {
    }

    public static MotorBikeRepo getInstance() {
        if (motorBikeRepo == null) {
            return new MotorBikeRepo();
        }
        return motorBikeRepo;
    }

    @Override
    public List<Motorbike> readFile() throws IOException {
        List<Motorbike> motorbikeList = new ArrayList<>();
        File file = new File("vehicle.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            motorbikeList = (List<Motorbike>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return motorbikeList;
    }

    @Override
    public void writeFile(List<Motorbike> motorbikeList) throws IOException, ClassNotFoundException {
        try {
            File file = new File("vehicle.txt");
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(motorbikeList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
