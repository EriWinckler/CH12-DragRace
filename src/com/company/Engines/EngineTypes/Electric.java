package com.company.Engines.EngineTypes;

import com.company.Engines.Engine;

public class Electric extends Engine {
    private int accelerationRate = 10;

    public Electric() {
        this.setType("Electric");
        this.setElectric(true);
    }

    public int getAccelerationRate() {
        return accelerationRate;
    }
}
