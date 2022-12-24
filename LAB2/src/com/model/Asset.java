package com.model;

import java.io.Serializable;

public class Asset implements Serializable {
    private String assetsID;
    private String name;
    private String color;
    private int price;
    private String weight;
    private int quantity;

    public Asset() {
    }

    public Asset(String assetsID, String name, String color, int price, String weight, int quantity) {
        this.assetsID = assetsID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Asset(String name, String color, int price, String weight, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetsID() {
        return assetsID;
    }

    public void setAssetsID(String assetsID) {
        this.assetsID = assetsID;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Assest{" +
                "assetsID='" + assetsID + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }
}
