package com.service.car;

import com.model.Car;
import com.repo.car.CarRepo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarService implements ICarService, Serializable {
    private CarRepo carRepo = CarRepo.getInstance();
    private List<Car> carList = null;

    public CarService() {
        try {
            carList = carRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Car car) {
        carList.add(car);
        try {
            carRepo.writeFile(carList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> findAll() {
        return carList;
    }

    @Override
    public void update(Car car) {
        for (int i = 0; i < carList.size(); i++) {
            if (Objects.equals(carList.get(i).getId(), car.getId())) {
                carList.set(i, car);
                break;
            }
        }
        try {
            carRepo.writeFile(carList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Car car) {
        carList.remove(car);
        try {
            carRepo.writeFile(carList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findById(Long id) {
        Car car = null;
        for (int i = 0; i < carList.size(); i++) {
            if (Objects.equals(carList.get(i).getId(),id)) {
                car = carList.get(i);
                break;
            }
        }
        return car;
    }

    @Override
    public List<Car> findByName(String name) {
        List<Car> cars= new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().contains(name)){
                cars.add(carList.get(i));
            }
        }
        return cars;
    }
}
