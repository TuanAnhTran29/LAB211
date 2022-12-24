package com.service.motorbike;

import com.model.Motorbike;
import com.repo.motorbike.MotorBikeRepo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MotorbikeService implements IMotorbikeService, Serializable {
    private static List<Motorbike> motorbikeList= new ArrayList<>();
    private static MotorBikeRepo motorBikeRepo = MotorBikeRepo.getInstance();
    private static boolean checked= false;

    public MotorbikeService() {
        try {
            motorbikeList = motorBikeRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Motorbike motorbike) {
        motorbikeList.add(motorbike);
        try {
            motorBikeRepo.writeFile(motorbikeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Motorbike> findAll() {
        return motorbikeList;
    }

    @Override
    public void update(Motorbike motorbike) {
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (Objects.equals(motorbikeList.get(i).getId(), motorbike.getId())) {
                motorbikeList.set(i, motorbike);
                break;
            }
        }
        try {
            motorBikeRepo.writeFile(motorbikeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Motorbike motorbike) {
        motorbikeList.remove(motorbike);
        try {
            motorBikeRepo.writeFile(motorbikeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Motorbike findById(Long id) {
        Motorbike motorbike= null;
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (Objects.equals(motorbikeList.get(i).getId(), id)){
                motorbike= motorbikeList.get(i);
                break;
            }
        }
        return motorbike;
    }

    @Override
    public List<Motorbike> findByName(String name) {
        List<Motorbike> motorbikes= new ArrayList<>();
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (motorbikeList.get(i).getName().contains(name)){
                motorbikes.add(motorbikeList.get(i));
            }
        }
        return motorbikes;
    }
}
