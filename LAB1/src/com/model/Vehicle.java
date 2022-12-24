package com.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private Long id;
    private String name;
    private String color;
    private int price;
    private String brand;

    public Vehicle(Long id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public Vehicle(String name, String color, int price, String brand) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'';
    }
}
