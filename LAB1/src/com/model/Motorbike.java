package com.model;

import java.io.Serializable;

public class Motorbike extends Vehicle implements Serializable {
    private int speed;
    private String rLicense;

    public Motorbike(Long id, String name, String color, int price, String brand, int speed, String rLicense) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.rLicense = rLicense;
    }

    public Motorbike() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getrLicense() {
        return rLicense;
    }

    public void setrLicense(String rLicense) {
        this.rLicense = rLicense;
    }

    public void makeSound(){
        System.out.println("Tin tin tin");
    }

    @Override
    public String toString() {
        return  "Motorbike: " + super.toString() +
                " speed='" + speed + '\'' +
                ", rLicense=" + rLicense;
    }
}
