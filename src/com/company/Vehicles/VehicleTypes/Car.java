package com.company.Vehicles.VehicleTypes;

import com.company.Engines.Engine;
import com.company.Vehicles.Vehicle;

public class Car extends Vehicle {


    private boolean isOn;
    private int maxSpeed;
    private int currentSpeed = 0;
    private int accelerationRate;
    private int brakingPower;

    private Engine engine;

    public Car(Engine engine, String make, String model, int year, String color, int maxSpeed) {
        super(make, model, year, color);
        this.maxSpeed = maxSpeed;
        this.engine = engine;
    }

    public int defAcceleration() {
        if(engine.isElectric()) {
            return accelerationRate = 10;
        } else if (engine.isHybrid()) {
            return accelerationRate = 7;
        } else {
            return accelerationRate = 5;
        }
    }

    public int defBraking() {
        if(engine.isElectric()) {
            return brakingPower = 10;
        } else if (engine.isHybrid()) {
            return brakingPower = 7;
        } else {
            return brakingPower = 5;
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getAccelerationRate() { return accelerationRate; }



    @Override
    public void startStop() {
        if(isOn) {
            System.out.println("Turning " + getModel() + " electronics off");
            isOn = false;
        } else {
            System.out.println("Turning " + getModel() + " electronics on");
            isOn = true;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Car info:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Max speed: " + maxSpeed);
    }
}
