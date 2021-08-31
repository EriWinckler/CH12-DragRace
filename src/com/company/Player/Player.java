package com.company.Player;

import com.company.Engine.Engine;
import com.company.Engine.Type.Electric;
import com.company.Engine.Type.Hybrid;
import com.company.Engine.Type.Ice;
import com.company.Vehicle.Type.Car;

public class Player {

    //storing player name
    private String name;

    //initializing Vehicle variables
    private Car carChoice;
    private String engineType;
    Engine engineChoice = null;


    //initializing speed variable
    private int currentSpeed = 0;
    
    //initializing location
    private int location = 0;

    //initializing gas
    private int gas = 2;

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
    
    public Engine setEngine(String engineType) {
        switch(engineType) {
            case "Electric":
                engineChoice = new Electric(false);
                break;

            case "Hybrid":
                engineChoice = new Hybrid(false);
                break;

            case "Ice":
                engineChoice = new Ice(false);
                break;

            default:
                System.out.println("Invalid engine choice, please try again!");
                break;
        }
        return engineChoice;
    }
    
    public void acceleration() {
        if(currentSpeed >= carChoice.getMaxSpeed()) {
            System.out.println("You reached your car speed limit of " + carChoice.getMaxSpeed());
            System.out.println("You can only cruise.");
            cruise();
        } else {
            currentSpeed = engineChoice.getAccelerationRate() + currentSpeed;
            System.out.println(name + " your speed is " + currentSpeed);

            //update gas
            gasConsume();
        }
        //update location
        locationUpdate();
    }
    
    public void cruise() {
        System.out.println(name + " is cruising and lost some speed due " +
                "to drag.");
        currentSpeed--;
        System.out.println("Your speed is now: " + currentSpeed);

        //update location
        locationUpdate();
    }
    
    public void breakVehicle() {
        if(currentSpeed >= 0) {
            System.out.println("You are stopped");
            System.out.println("You are " + location + " ahead of the start location.");
        } else {
            currentSpeed = currentSpeed - carChoice.getBrakingPower();
            System.out.println(name + " slowed your speed to " + currentSpeed);

            //update location
            locationUpdate();
        }
    }

    public void gasConsume() { gas = gas - 2; }

    public void gasRefuel() { gas++; }

    public void locationUpdate() {
        location = location + currentSpeed;
        System.out.println("You are " + location + " ahead of the start location.");
    }

    public void resetLocation() {
        location = 0;
    }
    
    public Car getCarChoice() {
        return carChoice;
    }

    public boolean getEngineStatus() { return engineChoice.getIsOn(); }

    public String setEngineOnOff() { return engineChoice.setStartStop(); }

    public int getLocation() { return location; }

    public int getCurrentSpeed() { return currentSpeed; }

    public int getGas() { return gas; }

}
