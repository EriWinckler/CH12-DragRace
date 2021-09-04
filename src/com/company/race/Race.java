package com.company.race;

import com.company.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {

    Scanner scan = new Scanner(System.in);
    Lane lane = new Lane();

    Player currentPlayer = new Player();

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    //checker for game active and mode
    private boolean gameOn = true;
    private boolean kamikazeWall = false;

    //pass counter
    private int pass = 0;

    private String checkedEngineType = "";


    public void startGame() {
        System.out.println("Welcome to Eri's World Stars Drag Race.");
        System.out.println("This is a car race, not that race you found in Google!");
        System.out.println("Please enter first player name");
        players.add(createPlayer());


        System.out.println("Please enter second player name");
        players.add(createPlayer());

        System.out.println("What's the size of the strip in meters?");
        int laneSize = Integer.parseInt(scan.nextLine());
        lane.setLaneSize(laneSize);

        //checker for Kamikaze mode
        System.out.println("Would you like to play KAMIKAZE mode?");
        String kamikaze = scan.nextLine().toLowerCase();
        setKamikaze(kamikaze);

        System.out.println("Let the race start!");

        while (gameOn) {
            drag();
        }
    }

    //Player creator method
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

        //calling verifier for valid input for the engine type
        checkEngineValidInput();

        System.out.println("What's the car color?");
        String carColor = scan.nextLine();

       //calling checker for valid max speed value
        int carMaxSpeed = checkMaxSpeed();

        //creating new player
        newPlayer.setCar(carMake, carModel, checkedEngineType, carYear,
                carColor, carMaxSpeed);

        return newPlayer;
    }

    //checker valid input for engine type
    public void checkEngineValidInput() {
        System.out.println("What's the car Engine type? (Electric, Hybrid, Ice)");
        String engineType = scan.nextLine().toLowerCase();

        switch (engineType) {
            case "electric":
                checkedEngineType = "Electric";
                break;

            case "hybrid":
                checkedEngineType = "Hybrid";
                break;

            case "ice":
                checkedEngineType = "Ice";
                break;

            default:
                System.out.println("Invalid engine choice, please try again");
                checkEngineValidInput();
                break;
        }
    }

    //checker for valid max speed input
    public int checkMaxSpeed() {
        System.out.println("What's the car max speed?");
        int maxSpeed = Integer.parseInt(scan.nextLine());

        if(maxSpeed > 300) {
            System.out.println("Invalid max speed, don't lie, your car cannot" +
                    " go that fast!");
            System.out.println("Setting car max speed to 300");
            return maxSpeed = 300;
        }
        return maxSpeed;
    }

    public void setKamikaze(String kamikaze) {
        switch (kamikaze) {
            case "yes" -> {
                kamikazeWall = true;
                System.out.println("\nKamikaze Mode is ON!\n");
            }
            default -> kamikazeWall = false;
        }
    }

    //Rounds method
    public void drag() {
        while (gameOn) {
            pass++;
            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);
                options();
                currentPlayer.gasRefuel();
                if (currentPlayer.getLocation() >= lane.getLaneSize()) {
                    System.out.println(currentPlayer.getName() + " Won!! It " +
                            "took " + pass + " turns. Your speed was " + currentPlayer.getCurrentSpeed() + ". " +
                            "Congratulations little burned rubber head");
                    //getCarInfo();
                    gameOn = false;
                    if(kamikazeWall) {
                        Wall wall = new Wall(currentPlayer, lane, true);
                        return;
                    }

                    break;
                }
            }
        }
    }

    //Player input method
    public void options() {
        if(!currentPlayer.getEngineStatus()) {
            System.out.println(currentPlayer.getName() + " Is your car's " +
                    "engine on? " + currentPlayer.getEngineStatus());
            System.out.println("Press any key turn it on/off");
            String anyKey = scan.nextLine();
            currentPlayer.setEngineOnOff();
        } else {
            String option;
            if(currentPlayer.getGas() == 0) {
                System.out.println(currentPlayer.getName() + " ran out of gas");
                System.out.println("These are your options:");
                System.out.println("2 - Cruise");
                System.out.println("3 - Brake");
                System.out.println("What will you do?");
                option = scan.nextLine();
            } else {
                System.out.println("It's " + currentPlayer.getName() + " turn, " + "currently you have " +
                        currentPlayer.getGas() + " gas left in your tank");
                System.out.println("These are your options:");
                System.out.println("1 - Accelerate");
                System.out.println("2 - Cruise");
                System.out.println("3 - Brake");
                System.out.println("What will you do?");
                option = scan.nextLine();
            }

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

    public void getCarInfo() {
        System.out.println("The winner's car:");
        System.out.println("Car make: " + currentPlayer.getCarChoice().getMake());
        System.out.println("Model: " + currentPlayer.getCarChoice().getModel());
        System.out.println("Year:" + currentPlayer.getCarChoice().getYear() + " Color: " + currentPlayer.getCarChoice().getColor());
        System.out.println("Max speed: " + currentPlayer.getCarChoice().getMaxSpeed());
    }
}

