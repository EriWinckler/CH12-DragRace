package com.company.console;

public class English implements Language {
    @Override
    public String[] startGame() {
        return new String[] {
                "Welcome to Eri's World Stars Drag Race.\n",
                "This is a car race, not that race you found in Google!\n"
        };
    }

    @Override
    public String playerOne() {
        return "Please enter first player name";
    }

    @Override
    public String playerTwo() {
        return "Please enter second player name";
    }

    @Override
    public String laneSize() {
        return "What's the size of the strip";
    }

    @Override
    public String kamikaze() {
        return "Would you like to play KAMIKAZE mode? Yes or No";
    }

    @Override
    public String start() {
        return "Let the race start!\n";
    }



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
