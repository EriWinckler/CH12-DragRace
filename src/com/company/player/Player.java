package com.company.player;

import com.company.console.Language;
import com.company.engine.Engine;
import com.company.engine.type.Electric;
import com.company.engine.type.Hybrid;
import com.company.engine.type.Ice;
import com.company.vehicle.type.Car;

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
        }
        return engineChoice;
    }
    
    public void acceleration(Language language, Car carChoice) {
        if(currentSpeed >= carChoice.getMaxSpeed()) {
            System.out.println(language.acceleMax(carChoice));
            cruise(language);
        } else {
            currentSpeed = engineChoice.getAccelerationRate() + currentSpeed;
            language.acceleration(name, currentSpeed);
            //System.out.println(name + " your speed is " + currentSpeed);

            //update gas
            gasConsume();
        }
        //update location
        locationUpdate();
    }
    
    public void cruise(Language language) {
        if(getCurrentSpeed() >= 0) {
            System.out.println(language.stopped());
        } else {
            //System.out.println(name + " is cruising and lost some speed due to drag.");
            System.out.println(language.cruise(name));
            currentSpeed--;
            //System.out.println("Your speed is now: " + currentSpeed);
            System.out.println(language.cruiseDisplaySpeed(currentSpeed));

            //update location
            locationUpdate();
        }
    }
    
    public void breakVehicle(Language language) {
        if(getCurrentSpeed() >= 0) {
            System.out.println(language.stopped());
        } else {
            currentSpeed -= carChoice.getBrakingPower();
            System.out.println(language.brake(name, currentSpeed));

            //update location
            locationUpdate();
        }
    }

    public void gasConsume() { gas = gas - 2; }

    public void gasRefuel() { gas++; }

    public void locationUpdate() {
        location += currentSpeed;
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
