package com.company.console;

public interface Language {
    String[] startGame();
    String playerOne;
    String playerTwo;
    String laneSize;
    String kamikaze;
    String start;

    //createPlayer
    String [] carMake;
    String carModel;
    String carYear;
    String carColor;

    //checkEngineValidInput
    String typeEngine;
    String invalidChoice;

    //checkMaxSpeed
    String carMaxSpeed;
    String [] invalidMax;

    //setKamkikaze
    String kamikazeOn;

    //drag
    String win;
    String speed;
    String congrats;

    //options
    String engineOn;
    String turnOn;

    String outGas;
    String[] noGasOptions;
    String invalidOptions;
    String gasInfom;
    String [] gasOptions;

    //wall
    String intro;
    String wallInfo;
    String checker;
    String[] speedInfo;
    String hitWall;
    String safe;

}
