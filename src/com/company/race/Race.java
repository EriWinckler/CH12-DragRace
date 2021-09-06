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
        System.out.println("Welcome, what language would you like? || Bem vindo, que lingua você gostaria?");
        System.out.println("1. English   2. Português");
        int choice = Integer.parseInt(scan.nextLine());
        switch (choice) {
            case 2 -> language = new Portuguese();
            default -> language = new English();
        }
    }

    public void startGame() {
        setLang();
        displayString(language.startGame());

        System.out.println(language.playerOne());
        String name = (scan.nextLine());
        players.add(createPlayer(name));

        System.out.println(language.playerTwo());
        name = (scan.nextLine());
        players.add(createPlayer(name));

        System.out.println(language.laneSize());
        String input = (scan.nextLine());

        try {
            int laneSize = Integer.parseInt(input);
            lane.setLaneSize(laneSize);
        } catch (Exception e) {
            System.out.println(e);

        }



        //checker for Kamikaze mode
        System.out.println(language.kamikaze());
        String kamikaze = scan.nextLine().toLowerCase();
        setKamikaze(kamikaze);

        language.start();

        while (gameOn) {
            drag();
        }
    }

    public static void displayString(String[] options) {
        for(String option : options) {
            System.out.println(option);
        }
    }

    //Player creator method
    public Player createPlayer(String name) {
        Player newPlayer = new Player();

        newPlayer.setName(name);

        displayString(language.carMake());
        String carMake = scan.nextLine();

        System.out.println(language.carModel());
        String carModel = scan.nextLine();

        System.out.println(language.carYear());
        String input = (scan.nextLine());

        try {
            int carYear = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        //calling verifier for valid input for the engine type
        checkEngineValidInput();

        System.out.println(language.carColor());
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
        System.out.println(language.typeEngine());
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
                System.out.println(language.invalidChoice());
                checkEngineValidInput();
                break;
        }
    }

    //checker for valid max speed input
    public int checkMaxSpeed() {
        System.out.println(language.carMaxSpeed());
        String input = scan.nextLine();
        try {
            maxSpeed = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e);
        }

        if(maxSpeed > 300) {
            displayString(language.invalidMax());
            return maxSpeed = 300;
        }
        return maxSpeed;
    }

    public void setKamikaze(String kamikaze) {
        switch (kamikaze) {
            case ("yes") -> {
                kamikazeWall = true;
                System.out.println(language.kamikazeOn());
            }
            default -> kamikazeWall = false;
        }
    }

    //Rounds method
    public void drag() {
        while (gameOn) {
            pass++;
            for (Player player : players) {
                currentPlayer = player;
                options();
                currentPlayer.gasRefuel();
                if (currentPlayer.getLocation() >= lane.getLaneSize()) {
                    System.out.println(language.win(currentPlayer, pass));
                    gameOn = false;
                    if (kamikazeWall) {
                        wall(currentPlayer, lane, true);
                        return;
                    }
                    getCarInfo();
                    break;
                }
            }
        }
    }

    //Player input method
    public void options() {
        if(!currentPlayer.getEngineStatus()) {
            System.out.println(language.engineOn(currentPlayer));
            System.out.println(language.turnOn());
            String anyKey = scan.nextLine();
            currentPlayer.setEngineOnOff();
        } else {
            String option;
            if(currentPlayer.getGas() == 0) {
                System.out.println(language.acceleration(currentPlayer.getName(), currentPlayer.getCurrentSpeed()));
                displayString(language.outGas(currentPlayer));
                option = scan.nextLine();

                switch (option) {
                    case "2" -> currentPlayer.cruise(language);
                    case "3" -> currentPlayer.breakVehicle(language);
                    default -> {
                        System.out.println(language.invalidChoice());
                        options();
                    }
                }

            } else {
                System.out.println(language.acceleration(currentPlayer.getName(), currentPlayer.getCurrentSpeed()));
                displayString(language.gasInfo(currentPlayer));
                option = scan.nextLine();

                switch (option) {
                    case ("1"):
                        currentPlayer.acceleration(language, currentPlayer.getCarChoice());
                        break;

                    case "2":
                        currentPlayer.cruise(language);
                        break;

                    case "3":
                        currentPlayer.breakVehicle(language);
                        break;

                    default:
                        System.out.println(language.invalidChoice());
                        options();

                }

            }
        }
    }

    public void wall(Player currentPlayer, Lane lane, boolean kamikaze) {
        wallOfDoom = (int) (lane.getLaneSize() * 0.4);
        currentPlayer.resetLocation();

        displayString(language.wallIntro(wallOfDoom));
        String option = scan.nextLine();

        while (kamikaze) {
            displayString(language.wallInfo(currentPlayer, wallOfDoom));

            if (currentPlayer.getLocation() >= wallOfDoom) {
                System.out.println(language.hitWall());
                kamikaze = false;
                getCarInfo();
                return;
            } else if (currentPlayer.getCurrentSpeed() == 0) {
                System.out.println(language.safe());
                kamikaze = false;
                getCarInfo();
                return;
            } else {
                options();
            }
        }
    }

    public void getCarInfo() {
        displayString(language.carInfo(currentPlayer));
    }
}

