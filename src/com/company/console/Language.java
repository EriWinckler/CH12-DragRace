package com.company.console;

import com.company.player.Player;

public interface Language {
    String[] startGame();
    String playerOne();
    String playerTwo();
    String laneSize();
    String kamikaze();
    String start();

    //createPlayer
    String [] carMake();
    String carModel();
    String carYear();
    String carColor();

    //checkEngineValidInput
    String typeEngine();
    String invalidChoice();

    //checkMaxSpeed
    String carMaxSpeed();
    String [] invalidMax();

    //setKamkikaze
    String kamikazeOn();

    //drag
    String win(Player currentPlayer, int pass);


    //options
    String engineOn(Player currentPlayer);
    String turnOn();

    String[] outGas(Player currentPlayer);
    String[] gasInfo(Player currentPlayer);


    //wall
    String[] wallIntro(int wallOfDoom);
    String[] wallInfo(Player currentPlayer, int wallOfDoom);
    String hitWall();
    String safe();

}
