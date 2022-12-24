package com.controller;

import com.model.Motorbike;
import com.service.motorbike.IMotorbikeService;
import com.service.motorbike.MotorbikeService;

import java.util.List;

public class MotorbikeController implements GeneralController<Motorbike> {
    private final IMotorbikeService motorbikeService;

    public MotorbikeController() {
        motorbikeService= new MotorbikeService();
    }

    @Override
    public void add(Motorbike motorbike) {
        motorbikeService.add(motorbike);
    }

    @Override
    public void update(Motorbike motorbike) {
        motorbikeService.update(motorbike);
    }

    @Override
    public void delete(Motorbike motorbike) {
        motorbikeService.delete(motorbike);
    }

    @Override
    public List<Motorbike> findAll() {
        return motorbikeService.findAll();
    }

    @Override
    public Motorbike findById(Long id) {
        return motorbikeService.findById(id);
    }

    @Override
    public List<Motorbike> findByName(String name) {
        return motorbikeService.findByName(name);
    }
}
