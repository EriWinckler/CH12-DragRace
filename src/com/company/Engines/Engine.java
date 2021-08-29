package com.company.Engines;

public class Engine {
    private String type;
    private boolean isOn = false;
    private boolean isIce = false;
    private boolean isElectric = false;
    private boolean isHybrid = false;
    private int accelerationRate = 0;

    public void startStop() {
        if(isOn) {
            System.out.println("Turning engine off");
            isOn = false;
        } else {
            System.out.println("Turning engine on");
            isOn = true;
        }
    }

    public int setAccelerationRate() {
        if(isIce) {
            return accelerationRate = 5;
        } else if (isElectric) {
            return accelerationRate = 15;
        } else {
            return accelerationRate = 10;
        }
    }

    public void info() {
        System.out.println("Engine info:");
        System.out.println("Type: " + getType());
        if(isIce) {
            System.out.println("Internal Combustion Engine");
        } else if (isElectric) {
            System.out.println("Electric Engine");
        } else {
            System.out.println("Hybrid engine");
        }
    }

    public String getType() {
        return type;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isIce() {
        return isIce;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public boolean isHybrid() {
        return isHybrid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setIce(boolean gas) {
        isIce = gas;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public void setHybrid(boolean hybrid) {
        isHybrid = hybrid;
    }
}
