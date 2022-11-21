package com.rentcar.rentapp.model;


public class Client {
    //private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;

    public Client(int id, String name) {
        this.id = id;
    //    this.id = count.incrementAndGet();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
