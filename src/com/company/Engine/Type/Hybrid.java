package com.company.Engine.Type;

import com.company.Engine.Engine;

public class Hybrid extends Engine {

    public Hybrid(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 7;

    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
