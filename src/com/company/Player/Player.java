package com.company.Player;

import com.company.Engine.Engine;
import com.company.Vehicle.Type.Car;

public class Player {

    //storing player name
    private String name;

    //initializing Vehicle variables
    private Car carChoice;
    private Engine engineChoice = new Engine();
    private String engineType;

    //initializing speed variable
    private int currentSpeed = 0;
    
    //initializing location
    private int location = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String carMake, String carModel, String engineType,
                       int carYear, String carColor, int carMaxSpeed) {
        Car carChoice = new Car(carMake, carModel, carYear,
                carColor, carMaxSpeed);
        this.carChoice = carChoice;
        this.engineType = engineType;
        setEngine(engineType);
    }
    
    public void setEngine(String engineType) {
        engineChoice.defineEngineType(engineType);
    }
    
    public void acceleration() {
        currentSpeed = engineChoice.getAccelerationRate() + currentSpeed;
        System.out.println("Your speed is " + currentSpeed);
        
        //update location
        locationUpdate();
    }
    
    public void cruise() {
        System.out.println("Your speed is kept at " + currentSpeed);
        //update location
        locationUpdate();
    }
    
    public void breakVehicle() {
        if(currentSpeed == 0) {
            System.out.println("You are at a stop, can brake more than that.");
        } else {
            currentSpeed = currentSpeed - carChoice.getBrakingPower();
            
            //update location
            locationUpdate();
        }
    }
    
    public void locationUpdate() {
        location = location + currentSpeed;
        System.out.println("You are " + location + " ahead of the start location.");
    }
    
    public Car getCarChoice() {
        return carChoice;
    }
    
    public int getLocation() { return location;}

}
