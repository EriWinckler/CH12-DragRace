package com.company.Vehicle.Type;

import com.company.Engine.Engine;

import com.company.Vehicle.Vehicle;

public class Car extends Vehicle {

    private int maxSpeed;
    private int currentSpeed = 0;
    private int brakingPower = 10;

    public Car(String make, String model, int year, String color, int maxSpeed) {
        super(make, model, year, color);
        this.maxSpeed = maxSpeed;
    }


    public int getBrakingPower() { return brakingPower; }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
