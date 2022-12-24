package com.service;

import com.model.Vehicle;
import com.repo.VehicleRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleService implements IGeneralService<Vehicle>{
    private static VehicleRepo vehicleRepo= VehicleRepo.getInstance();
    private static List<Vehicle> vehicleList= null;

    public VehicleService() {
        try {
            vehicleList= vehicleRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleList.add(vehicle);
        try {
            vehicleRepo.writeFile(vehicleList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public void update(Vehicle vehicle) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (Objects.equals(vehicleList.get(i).getId(), vehicle.getId())){
                vehicleList.set(i,vehicle);
                break;
            }
        }
        try {
            vehicleRepo.writeFile(vehicleList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleList.remove(vehicle);
        try {
            vehicleRepo.writeFile(vehicleList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehicle findById(Long id) {
        Vehicle vehicle= null;
        for (int i = 0; i < vehicleList.size(); i++) {
            if (Objects.equals(vehicleList.get(i).getId(), id)){
                vehicle= vehicleList.get(i);
                break;
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findByName(String name) {
        List<Vehicle> vehicles= new ArrayList<>();
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getName().contains(name)){
                vehicles.add(vehicleList.get(i));
            }
        }
        return vehicles;
    }
}
