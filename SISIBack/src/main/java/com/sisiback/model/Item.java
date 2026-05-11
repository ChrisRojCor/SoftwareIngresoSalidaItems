package com.sisiback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    private String id;
    private String name;
    private String model;
    private String brand;
    private String customerId;
    private String date;
    private String customerName;
    private String phone;
    private String comment;
    private String service;
    private String serviceNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", customerId='" + customerId + '\'' +
                ", date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", service='" + service + '\'' +
                ", serviceNumber='" + serviceNumber + '\'' +
                '}';
    }
}
