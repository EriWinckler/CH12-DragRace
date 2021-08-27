package com.company.Vehicles;

public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;


    public Vehicle(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public abstract void startStop();

    public abstract void printInfo();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

}
