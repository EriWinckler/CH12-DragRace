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
    private Language language;
    private boolean bonus = false;
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
                       int carYear, String carColor,
                       int carMaxSpeed) {
        Car carChoice = new Car(carMake, carModel, carYear,
                carColor, carMaxSpeed);
        this.carChoice = carChoice;
        this.engineType = engineType;
        setEngine(engineType);
        setAcceleration(carModel, carColor);
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

    public void setAcceleration(String carModel, String carColor) {
        if(carModel.toLowerCase().equals("prius") && carColor.toLowerCase().equals("red")) {
            engineChoice.setAccelerationRate(45);
            carChoice.setBrakingPower(35);
            System.out.println(language.BONUS());
        }
    }
    
    public void acceleration(Language language, Car carChoice) {
        if(currentSpeed >= carChoice.getMaxSpeed()) {
            System.out.println(language.ACCE_MAX(carChoice));
            cruise(language);
        } else {
            currentSpeed += engineChoice.getAccelerationRate();
            language.ACCELERATION(name, currentSpeed);

            //update gas
            gasConsume();
        }
        //update location
        locationUpdate();
    }
    
    public void cruise(Language language) {
        if(currentSpeed <= 0) {
            System.out.println(language.CRUISE_DISPLAY_SPEED(currentSpeed));
            currentSpeed = 0;
            return;
        }

            System.out.println(language.CRUISE(name));
            currentSpeed--;
            System.out.println(language.CRUISE_DISPLAY_SPEED(currentSpeed));

            //update location
            locationUpdate();
    }
    
    public void breakVehicle(Language language) {
        if(currentSpeed <= 0) {
            System.out.println(language.STOPPED());
            currentSpeed = 0;
            return;
        }
            currentSpeed -= carChoice.getBrakingPower();
            System.out.println(language.BRAKE(name, currentSpeed));

            //update location
            locationUpdate();
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

    public Language setLanguage(Language lang) { return this.language = lang; }
}
