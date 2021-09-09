package com.company.engine;

public abstract class Engine {

    //Checker is vehicle is on/off
    private boolean isOn = false;

    public Engine(boolean isOn) {
        this.isOn = isOn;
    }

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

    public abstract int  getAccelerationRate();

    public boolean getIsOn() { return isOn; }

    public abstract void setAccelerationRate(int accelerationRate);
}
