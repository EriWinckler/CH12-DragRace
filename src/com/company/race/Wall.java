package com.company.race;

import com.company.engine.Engine;
import com.company.player.Player;

public class Wall {

    //Wall distance
    private int wallOfDoom;

    Race race = new Race();

    public Wall(Player currentPlayer, Lane lane, boolean kamikaze) {
        wallOfDoom = (int) (lane.getLaneSize() * 0.4);
        currentPlayer.resetLocation();

        System.out.println("Let's see if you are a REAL KAMIKAZE!");
        System.out.println("The KAMIKAZE wall is " + wallOfDoom + " in front " +
                "of you");


        while(kamikaze) {
            System.out.println(currentPlayer.getName() + " you are driving at" +
                    " " + currentPlayer.getCurrentSpeed());
            System.out.println("The KAMIKAZE wall is " + (wallOfDoom + currentPlayer.getLocation()) +
                    " in front of you");

            if(currentPlayer.getLocation() >= wallOfDoom) {
                System.out.println("YOU HIT THE WALL AND COMPLETED YOUR " +
                        "KAMIKAZE MISSION!");
                kamikaze = false;
                return;
            } else if(currentPlayer.getCurrentSpeed() == 0) {
                System.out.println("Congratulations you stopped before " +
                        "hitting the wall");
                kamikaze = false;
                return;
            } else {
                race.options();
            }

        }
    }
}
