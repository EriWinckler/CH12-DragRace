package com.company.engine.type;

import com.company.engine.Engine;

public class Hybrid extends Engine {

    public Hybrid(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 10;

    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
