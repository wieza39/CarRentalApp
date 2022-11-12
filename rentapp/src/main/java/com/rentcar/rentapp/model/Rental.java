package com.rentcar.rentapp.model;

public class Rental {
    private final Client client;
    private final Car car;

    public Rental(Client client, Car car){
        this.client = client;
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "client=" + client +
                ", car=" + car +
                '}';
    }
}
