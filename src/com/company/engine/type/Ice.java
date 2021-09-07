package com.company.engine.type;

import com.company.engine.Engine;

public class Ice extends Engine {

    public Ice(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 15;

    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
