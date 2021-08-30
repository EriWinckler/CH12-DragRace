package com.company.Engine;

public class Engine {
    private String type;

    //Checker is vehicle is on/off
    private boolean isOn = false;

    //Type of engine selector
    private boolean isIce = false;
    private boolean isElectric = false;
    private boolean isHybrid = false;

    //Rate of acceleration varies as per type of engine
    private int accelerationRate;


    public String setStartStop() {
        if(isOn) {
            System.out.println("Turning engine off");
            isOn = false;
        } else {
            System.out.println("Turning engine on");
            isOn = true;
        }
        return null;
    }

    public void defineEngineType(String engineType) {
        switch (engineType) {
            case "Hybrid":
                isHybrid = true;
                accelerationRate = 7;
                break;

            case "Electric":
                isElectric = true;
                accelerationRate = 10;
                break;

            case "Ice":
                isIce = true;
                accelerationRate = 5;
                break;

            default:
                System.out.println("Invalid engine choice, please try again.");
                return;
        }
    }
    public String getType() {
        return type;
    }

    public int getAccelerationRate() { return accelerationRate; }

    public boolean getIsOn() { return isOn; }
}
