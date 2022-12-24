package com.model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    private String type;
    private int yom;

    public Car(Long id, String name, String color, int price, String brand, String type, int yom) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yom = yom;
    }

    public Car(String name, String color, int price, String brand, String type, int yom) {
        super(name, color, price, brand);
        this.type = type;
        this.yom = yom;
    }

    public Car(String type, int yom) {
        this.type = type;
        this.yom = yom;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYom() {
        return yom;
    }

    public void setYom(int yom) {
        this.yom = yom;
    }

    @Override
    public String toString() {
        return  "Car: " + super.toString() +
                " type='" + type + '\'' +
                ", yom=" + yom;
    }
}
