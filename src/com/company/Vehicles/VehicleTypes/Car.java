package com.company.Vehicles.VehicleTypes;

import com.company.Engines.Engine;
import com.company.Vehicles.Vehicle;

public class Car extends Vehicle {


    private boolean isOn;
    private int maxSpeed;
    private int currentSpeed = 0;

    public Car(Engine engine, String make, String model, int year, String color, int maxSpeed) {
        super(make, model, year, color);
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int accelerationRate) {
        currentSpeed = currentSpeed + accelerationRate;
    }

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
