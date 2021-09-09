package com.company.vehicle.type;

import com.company.vehicle.Vehicle;

public class Car extends Vehicle {

    private int maxSpeed;
    private int brakingPower = 10;

    public Car(String make, String model, int year, String color, int maxSpeed) {
        super(make, model, year, color);
        this.maxSpeed = maxSpeed;
    }
    
    public int getBrakingPower() { return brakingPower; }

    public void setBrakingPower(int brakingPower) {
        this.brakingPower = brakingPower;
    }
    
    public int getMaxSpeed() { return maxSpeed; }
}
