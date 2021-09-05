package com.company.console;

import com.company.race.Lane;
import com.company.race.Race;

import java.util.Scanner;

public class UI {

    Scanner scan = new Scanner(System.in);

    Race race = new Race();
    Lane lane = new Lane();


    public void startGame() {
        /*System.out.println("Welcome to Eri's World Stars Drag Race.\n");
        System.out.println("This is a car race, not that race you found in Google!\n");
        System.out.println("Please enter first player name");
        race.players.add(race.createPlayer());

        System.out.println("Please enter second player name");
        race.players.add(race.createPlayer());

        System.out.println("What's the size of the strip in meters?");
        String input = (scan.nextLine());

        try {
            int laneSize = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        lane.setLaneSize(race.laneSize);

        //checker for Kamikaze mode
        System.out.println("Would you like to play KAMIKAZE mode? Yes or No");
        String kamikaze = scan.nextLine().toLowerCase();
        race.setKamikaze(kamikaze);

        System.out.println("Let the race start!\n");*/
    }

}
