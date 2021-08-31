package com.company.Engine.Type;

import com.company.Engine.Engine;

public class Electric extends Engine {

    public Electric(boolean isOn) {
        super(isOn);
    }

    //Rate of acceleration varies as per type of engine
    private int accelerationRate = 10;


    @Override
    public int getAccelerationRate() {
        return accelerationRate;
    }
}
