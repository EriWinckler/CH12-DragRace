package com.company.Engines.EngineTypes;

import com.company.Engines.Engine;

public class Hybrid extends Engine {
    private int accelerationRate = 7;

    public Hybrid() {
        this.setType("Hybrid");
        this.setHybrid(true);
    }

    public int getAccelerationRate() {
        return accelerationRate;
    }
}
