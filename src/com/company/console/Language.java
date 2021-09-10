package com.company.console;

import com.company.player.Player;
import com.company.vehicle.type.Car;

public interface Language {
    String[] STARTGAME();
    String PLAYER_ONE();
    String PLAYER_TWO();
    String LANE_SIZE();
    String KAMIKAZE();
    String START();

    //createPlayer
    String [] CAR_MAKE();
    String CAR_MODEL();
    String CAR_YEAR();
    String CAR_COLOR();
    String BONUS();

    //checkEngineValidInput
    String TYPE_ENGINE();
    String INVALID_CHOICE();

    //checkMaxSpeed
    String CAR_MAX_SPEED();
    String [] INVALID_MAX();

    //setKamkikaze
    String KAMIKAZE_ON();

    //drag
    String WIN(Player currentPlayer, int pass);


    //options
    String ENGINE_ON(Player currentPlayer);
    String TURN_ON();
    String LOCATION(Player currentPlayer, int laneSize);

    String[] OUT_GAS(Player currentPlayer);
    String[] GAS_INFO(Player currentPlayer);


    //wall
    String[] WALL_INTRO(int wallOfDoom);
    String[] WALL_INFO(Player currentPlayer, int wallOfDoom);
    String HIT_WALL();
    String SAFE();

    //displayCar
    String[] CAR_INFO(Player currentPlayer);

    //playerFile
    //acceleration
    String[] ACCE_MAX(Car carChoice);
    String DISPLAY_SPEED(String name, int currentSpeed);
    String ACCELERATION(String name, int currentSpeed);

    //cruise
    String CRUISE(String name);
    String CRUISE_DISPLAY_SPEED(int currentSpeed);

    //brake
    String STOPPED();
    String BRAKE(String name, int currentSpeed);

}
