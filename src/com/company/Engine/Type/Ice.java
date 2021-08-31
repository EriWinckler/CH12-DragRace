package com.company.Engine.Type;

import com.company.Engine.Engine;

public class Ice extends Engine {

    public Ice(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 5;

    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
