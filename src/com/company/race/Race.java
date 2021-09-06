package com.company.race;

import com.company.console.region.English;
import com.company.console.Language;
import com.company.console.region.Portuguese;
import com.company.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {

    Scanner scan = new Scanner(System.in);
    Lane lane = new Lane();

    private Language language;


    Player currentPlayer = new Player();

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    //checker for game active and mode
    private boolean gameOn = true;
    private boolean kamikazeWall = false;

    //pass counter
    private int pass = 0;


    private int wallOfDoom, laneSize, carYear, maxSpeed;

    private String checkedEngineType = "";


    private void setLang() {
        System.out.println("1. English\n2. Português");
        int choice = scan.nextInt();
        switch (choice) {
            case 1 -> language = new English();
            case 2 -> language = new Portuguese();
        }
    }

    public void startGame() {
        setLang();
        System.out.println(language.startGame());

        /*System.out.println("Welcome to Eri's World Stars Drag Race.\n");
        System.out.println("This is a car race, not that race you found in Google!\n");*/
        System.out.println(language.playerOne());
        players.add(createPlayer());


        //System.out.println("Please enter second player name");
        System.out.println(language.playerTwo());
        players.add(createPlayer());

        //System.out.println("What's the size of the strip in meters?");
        System.out.println(language.laneSize());
        String input = (scan.nextLine());

        try {
            int laneSize = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        lane.setLaneSize(laneSize);

        //checker for Kamikaze mode
        //System.out.println("Would you like to play KAMIKAZE mode? Yes or No");
        System.out.println(language.kamikaze());
        String kamikaze = scan.nextLine().toLowerCase();
        setKamikaze(kamikaze);

        //System.out.println("Let the race start!\n");
        language.start();

        while (gameOn) {
            drag();
        }
    }

    //Player creator method
    public Player createPlayer() {
        Player newPlayer = new Player();

        String name = scan.nextLine();
        newPlayer.setName(name);

        //System.out.println("Please enter the car you are driving");

        //System.out.println("What's the car make?");
        language.carMake();
        String carMake = scan.nextLine();

        //System.out.println("What's the car model?");
        language.carModel();
        String carModel = scan.nextLine();

        //System.out.println("What's the car year?");
        language.carYear();
        String input = (scan.nextLine());

        try {
            int carYear = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        //calling verifier for valid input for the engine type
        checkEngineValidInput();

        //System.out.println("What's the car color?");
        language.carColor();
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
        //System.out.println("What's the car Engine type? (Electric, Hybrid, Ice)");
        language.typeEngine();
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
                //System.out.println("Invalid engine choice, please try again");
                language.invalidChoice();
                checkEngineValidInput();
                break;
        }
    }

    //checker for valid max speed input
    public int checkMaxSpeed() {
        //System.out.println("What's the car max speed?");
        language.carMaxSpeed();
        String input = scan.nextLine();
        try {
            maxSpeed = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        if(maxSpeed > 300) {
            //System.out.println("Invalid max speed, don't lie, your car cannot" +
            //        " go that fast!");
            //System.out.println("Setting car max speed to 300");
            language.invalidMax();
            return maxSpeed = 300;
        }
        return maxSpeed;
    }

    public void setKamikaze(String kamikaze) {
        switch (kamikaze) {
            case "yes" -> {
                kamikazeWall = true;
                //System.out.println("\nKamikaze Mode is ON!\n");
                language.kamikazeOn();
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
                    /*System.out.println(currentPlayer.getName() + " Won!! It " +
                            "took " + pass + " turns. Your speed was " + currentPlayer.getCurrentSpeed() + ". " +
                            "Congratulations little burned rubber head");*/
                    language.win(currentPlayer, pass);
                    //getCarInfo();
                    gameOn = false;
                    if(kamikazeWall) {
                        wall(currentPlayer, lane, true);
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
            /*System.out.println(currentPlayer.getName() + " Is your car's " +
                    "engine on? " + currentPlayer.getEngineStatus());
            System.out.println("Press any key turn it on/off");*/
            language.engineOn(currentPlayer);
            language.turnOn();
            String anyKey = scan.nextLine();
            currentPlayer.setEngineOnOff();
        } else {
            String option;
            if(currentPlayer.getGas() == 0) {
                /*System.out.println(currentPlayer.getName() + " ran out of gas");
                System.out.println("These are your options:");
                System.out.println("2 - Cruise");
                System.out.println("3 - Brake");
                System.out.println("What will you do?");*/
                language.outGas(currentPlayer);
                option = scan.nextLine();

                switch (option) {
                    case "2":
                        currentPlayer.cruise();
                        break;

                    case "3":
                        currentPlayer.breakVehicle();
                        break;

                    default:
                        //System.out.println("Invalid choice, try again");
                        language.invalidChoice();
                        options();
                }

            } else {
                /*System.out.println("It's " + currentPlayer.getName() + " turn, " + "currently you have " +
                        currentPlayer.getGas() + " gas left in your tank");
                System.out.println("These are your options:");
                System.out.println("1 - Accelerate");
                System.out.println("2 - Cruise");
                System.out.println("3 - Brake");
                System.out.println("What will you do?");*/
                language.gasInfo(currentPlayer);
                option = scan.nextLine();

                switch (option) {
                    case ("1"):
                        currentPlayer.acceleration();
                        break;

                    case "2":
                        currentPlayer.cruise();
                        break;

                    case "3":
                        currentPlayer.breakVehicle();
                        break;

                    default:
                        //System.out.println("Invalid choice, try again");
                        language.invalidChoice();
                        options();

                }

            }
        }
    }

    public void wall(Player currentPlayer, Lane lane, boolean kamikaze) {
        wallOfDoom = (int) (lane.getLaneSize() * 0.4);
        currentPlayer.resetLocation();

        /*System.out.println("Let's see if you are a REAL KAMIKAZE!");
        System.out.println("The KAMIKAZE wall is " + wallOfDoom + " in front " +
                "of you");
        System.out.println("Are you ready?");*/
        language.wallIntro(wallOfDoom);
        String option = scan.nextLine();

        while (kamikaze) {
            /*System.out.println(currentPlayer.getName() + " you are driving at" +
                    " " + currentPlayer.getCurrentSpeed());
            System.out.println("The KAMIKAZE wall is " + (wallOfDoom - currentPlayer.getLocation()) +
                    " in front of you");*/
            language.wallInfo(currentPlayer, wallOfDoom);

            if (currentPlayer.getLocation() >= wallOfDoom) {
                /*System.out.println("YOU HIT THE WALL AND COMPLETED YOUR " +
                        "KAMIKAZE MISSION!");*/
                language.hitWall();
                kamikaze = false;
                getCarInfo();
                return;
            } else if (currentPlayer.getCurrentSpeed() == 0) {
                /*System.out.println("Congratulations you stopped before " +
                        "hitting the wall");*/
                language.safe();
                kamikaze = false;
                getCarInfo();
                return;
            } else {
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

