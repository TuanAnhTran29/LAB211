package com.repo.car;

import com.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements ICarRepo, Serializable {
    private static CarRepo carRepo= null;

    public static CarRepo getInstance() {
        if (carRepo == null) {
            return new CarRepo();
        }
        return carRepo;
    }

    @Override
    public List<Car> readFile() throws IOException {
        List<Car> carList = new ArrayList<>();
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
            carList = (List<Car>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public void writeFile(List<Car> carList) throws IOException, ClassNotFoundException {
        try {
            File file = new File("vehicle.txt");
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(carList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
