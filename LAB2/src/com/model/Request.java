package com.model;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
    private int rID;
    private String assestID;
    private Employee employeeID;
    private int quantity;
    private String requestDateTime;


    public Request() {
    }

    public Request(int rID, String assestID, Employee employeeID, int quantity, String requestDateTime) {
        this.rID = rID;
        this.assestID = assestID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public Request(String assestID, Employee employeeID, int quantity, String requestDateTime) {
        this.assestID = assestID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
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

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "rID='" + rID + '\'' +
                ", assestID=" + assestID +
                ", employeeID=" + employeeID.getEmployeeID() +
                ", quantity=" + quantity +
                ", requestDateTime='" + requestDateTime + '\'' +
                '}';
    }
}
