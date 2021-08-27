package com.company.Strip;

import java.util.ArrayList;
import java.util.Scanner;


import com.company.Engines.EngineTypes.Electric;
import com.company.Engines.EngineTypes.Hybrid;
import com.company.Engines.EngineTypes.Ice;
import com.company.Strip.Players.Player;
import com.company.Vehicles.VehicleTypes.Car;


public class Race {

    Scanner scan = new Scanner(System.in);
    Lane lane = new Lane();

    Player currentPlayer = new Player();

    private String choice;

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    //checker for game active
    private boolean gameOn = true;

    //pass counter
    private int pass = 0;

    public Race() {
        System.out.println("Welcome to Eri's World Stars Drag Race.");
        System.out.println("This is a car race, not that race you found in Google!");
        createPlayer();


        System.out.println("Please enter second player name");
        createPlayer();

        System.out.println("What's the size of the strip in meters?");
        int laneSize = scan.nextInt();
        lane.setLaneSize(laneSize);

        System.out.println("Let the race start!");

        while(gameOn) {
            drag();
        }

    }


    private Car createPlayer () {
        Player newPlayer = new Player();
        System.out.println("Please enter first player name");
        String name = scan.nextLine();
        newPlayer.setName(name);

        System.out.println("Please enter the car you are driving");
        System.out.println("What's the car Engine type? (Electric, Hybrid, Ice");
        String engineType = scan.nextLine();

        System.out.println("What's the car make?");
        String carMake = scan.nextLine();

        System.out.println("What's the car model?");
        String carModel = scan.nextLine();

        System.out.println("What's the car year?");
        int carYear = scan.nextInt();

        System.out.println("What's the car color?");
        String carColor = scan.nextLine();

        System.out.println("What's the car max speed?");
        int carMaxSpeed = scan.nextInt();

        switch(engineType) {
            case "Electric":
                Car electricCar = new Car(new Electric(), carMake, carModel, carYear, carColor, carMaxSpeed);
                return electricCar;

            case "Hybrid":
                Car hybridCar = new Car(new Hybrid(), carMake, carModel, carYear, carColor, carMaxSpeed);
                return hybridCar;

            case "Ice":
                Car iceCar = new Car(new Ice(), carMake, carModel, carYear, carColor, carMaxSpeed);
                return iceCar;

            default:
                System.out.println("Car not valid");
                return createPlayer();
        }

        return newPlayer;
    }

    public void drag() {
        pass++;
        while(gameOn) {
            for(int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);
                choice = options();
                playerAction(choice);
            }
        }
    }

    public String options() {
        System.out.println("It's " + currentPlayer.getName() + " turn, these are your options:");
        System.out.println("1 - Accelerate");
        System.out.println("2 - Cruise");
        System.out.println("3 - Brake");
        System.out.println("What will you do?");
        String option = scan.nextLine();

        switch (option) {
            case "1":

                return "1";

            case "2":
                return "2";

            case "3":
                return "3";

            default:
                System.out.println("Invalid choice, try again");
                return options();
        }
    }

    public void playerAction(String choice) {

    }
}
