package com.company.Strip.Players;

import com.company.Engines.Engine;
import com.company.Engines.EngineTypes.Electric;
import com.company.Engines.EngineTypes.Hybrid;
import com.company.Engines.EngineTypes.Ice;
import com.company.Vehicles.VehicleTypes.Car;

public class Player {

    private String name;
    private Engine engineChoice;

    private int currentSpeed = 0;


    Ice ice = new Ice();
    Electric electric = new Electric();
    Hybrid hybrid = new Hybrid();

    private Car carChoice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(String engine) {
        if(engine == "ice" || engine == "Ice") {
            engineChoice = ice;
        } else if(engine == "hybrid" || engine == "Hybrid") {
            engineChoice = hybrid;
        } else {
            engineChoice = electric;
        }
    }

    public void setCar(Engine playerEngine, String carMake, String carModel,
                      int carYear, String carColor, int carMaxSpeed) {
         Car carChoice = new Car(playerEngine, carMake, carModel, carYear,
                carColor, carMaxSpeed);
        this.carChoice = carChoice;
    }
    public void setCurrentSpeed() {
        accelerationRate = accelerationDef(engine);
        currentSpeed = currentSpeed + accelerationRate;
    }
    public void increaseSpeed() {
        currentSpeed = carChoice.defAcceleration(carChoice.) + currentSpeed;
    }
}
