package com.rentcar.rentapp.model;

import com.rentcar.rentapp.CarType;

public class Car {
    private String model;
    private String brand;
    private CarType carType;
    private String vin;
    private boolean isAvailable;

    public Car(String model, String brand, CarType carType, String vin) {
        this.model = model;
        this.brand = brand;
        this.carType = carType;
        this.vin = vin;
        this.isAvailable = true;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carType=" + carType +
                ", vin='" + vin + '\'' +
                '}';
    }
}
