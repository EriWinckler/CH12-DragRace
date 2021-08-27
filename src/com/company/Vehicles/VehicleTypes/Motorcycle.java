package com.company.Vehicles.VehicleTypes;

import com.company.Engines.Engine;
import com.company.Vehicles.Vehicle;

public class Motorcycle extends Vehicle {

    private int passengers;
    private boolean isOn;

    public Motorcycle(Engine engine, String make, String model, int year, String color, String type) {
        super(make, model, year, color, type);
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
    public void addPassenger(int passenger) {
        if(passengers > 2) {
            System.out.println("Bike is full");
            passengers = 2;
        } else {
            passengers = passenger + passengers;
        }
    }

    @Override
    public void removePassenger(int passenger) {
        if (passengers == 0) {
            System.out.println("There's no more passengers assign to this vehicle");
        } else {
            passengers =  passengers - passenger;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Motorcycle info:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Bike type: " + getType());
    }
}
