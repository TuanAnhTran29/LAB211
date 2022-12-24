package com.controller;


import com.model.Car;
import com.service.car.CarService;
import com.service.car.ICarService;

import java.util.List;

public class CarController implements GeneralController<Car> {
    private final ICarService carService;

    public CarController() {
        carService = new CarService();
    }

    @Override
    public void add(Car car) {
        carService.add(car);
    }

    @Override
    public void update(Car car) {
        carService.update(car);
    }

    @Override
    public void delete(Car car) {
        carService.delete(car);
    }

    @Override
    public List<Car> findAll() {
        return carService.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carService.findById(id);
    }

    @Override
    public List<Car> findByName(String name) {
        return carService.findByName(name);
    }
}
