package com.company.Race;

import com.company.Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {

    Scanner scan = new Scanner(System.in);
    Lane lane = new Lane();

    Player currentPlayer = new Player();


    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    //checker for game active
    private boolean gameOn = true;

    //pass counter
    private int pass = 0;


    public void startGame() {
        System.out.println("Welcome to Eri's World Stars Drag Race.");
        System.out.println("This is a car race, not that race you found in Google!");
        System.out.println("Please enter first player name");
        players.add(createPlayer());


        System.out.println("Please enter second player name");
        players.add(createPlayer());

        System.out.println("What's the size of the strip in meters?");
        int laneSize = scan.nextInt();
        lane.setLaneSize(laneSize);

        System.out.println("Let the race start!");

        while (gameOn) {
            drag();
        }

    }

    private Player createPlayer() {
        Player newPlayer = new Player();

        String name = scan.nextLine();
        newPlayer.setName(name);

        System.out.println("Please enter the car you are driving");

        System.out.println("What's the car make?");
        String carMake = scan.nextLine();

        System.out.println("What's the car model?");
        String carModel = scan.nextLine();

        System.out.println("What's the car year?");
        int carYear = Integer.parseInt(scan.nextLine());

        System.out.println("What's the car Engine type? (Electric, Hybrid, Ice)");
        String engineType = scan.nextLine();

        System.out.println("What's the car color?");
        String carColor = scan.nextLine();

        System.out.println("What's the car max speed?");
        int carMaxSpeed = Integer.parseInt(scan.nextLine());

        //creating new player
        newPlayer.setCar(carMake, carModel, engineType, carYear,
                carColor, carMaxSpeed);

        return newPlayer;
    }

    public void drag() {
        pass++;
        while (gameOn) {
            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);
                options();

                if (currentPlayer.getLocation() >= lane.getLaneSize()) {
                    System.out.println(currentPlayer.getName() + " Won!! Congratulations little burned rubber head");
                    gameOn = false;
                    break;
                }
            }
        }
    }

    public void options() {
        System.out.println("It's " + currentPlayer.getName() + " turn, these are your options:");
        System.out.println("1 - Accelerate");
        System.out.println("2 - Cruise");
        System.out.println("3 - Brake");
        System.out.println("What will you do?");
        String option = scan.nextLine();

        switch (option) {
            case "1":
                currentPlayer.acceleration();
                break;

            case "2":
                currentPlayer.cruise();
                break;

            case "3":
                currentPlayer.breakVehicle();
                break;

            default:
                System.out.println("Invalid choice, try again");
                options();
        }
    }
}

