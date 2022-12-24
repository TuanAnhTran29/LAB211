package com.model;

import java.io.Serializable;

public class Borrow implements Serializable {
    private int bID;
    private String assestID;
    private Employee employeeID;
    private int quantity;
    private String borrowDateTime;

    public Borrow() {
    }

    public Borrow(int bID, String assestID, Employee employeeID, int quantity, String borrowDateTime) {
        this.bID = bID;
        this.assestID = assestID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }

    public Borrow(String assestID, Employee employeeID, int quantity, String borrowDateTime) {
        this.assestID = assestID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public String getAssestID() {
        return assestID;
    }

    public void setAssestID(String assestID) {
        this.assestID = assestID;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(String borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "bID='" + bID + '\'' +
                ", assestID=" + assestID +
                ", employeeID=" + employeeID.getEmployeeID() +
                ", quantity=" + quantity +
                ", borrowDateTime='" + borrowDateTime + '\'' +
                '}';
    }
}
