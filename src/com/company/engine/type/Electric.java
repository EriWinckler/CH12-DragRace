package com.company.engine.type;

import com.company.engine.Engine;

public class Electric extends Engine {

    public Electric(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 25;


    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
