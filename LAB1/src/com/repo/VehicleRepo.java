package com.repo;

import com.model.Car;
import com.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepo implements ILoadingFile<Vehicle> {
    private static VehicleRepo vehicleRepo;

    public static VehicleRepo getInstance(){
        if (vehicleRepo == null){
            return new VehicleRepo();
        }
        return vehicleRepo;
    }
    @Override
    public List<Vehicle> readFile() throws IOException {
        List<Vehicle> vehicleList= new ArrayList<>();
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
            vehicleList = (List<Vehicle>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public void writeFile(List<Vehicle> vehicleList) throws IOException, ClassNotFoundException {
        try {
            File file = new File("vehicle.txt");
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(vehicleList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
