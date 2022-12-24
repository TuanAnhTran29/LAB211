package com.controller;

import com.model.Vehicle;
import com.service.VehicleService;

import java.util.List;

public class VehicleController implements GeneralController<Vehicle> {
    private final VehicleService vehicleService;

    public VehicleController() {
        vehicleService= new VehicleService();
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleService.add(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleService.update(vehicle);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleService.delete(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleService.findById(id);
    }

    @Override
    public List<Vehicle> findByName(String name) {
        return vehicleService.findByName(name);
    }
}
