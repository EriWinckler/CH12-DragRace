package com.company.Engines.EngineTypes;

import com.company.Engines.Engine;

public class Ice extends Engine {

    private int accelerationRate = 1;

    public Ice() {
        this.setType("ICE");
        this.setIce(true);
    }

    public int getAccelerationRate() {
        return accelerationRate;
    }
}
