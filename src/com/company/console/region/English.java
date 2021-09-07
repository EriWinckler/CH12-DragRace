package com.company.console.region;

import com.company.console.Language;
import com.company.player.Player;
import com.company.vehicle.type.Car;

public class English implements Language {

    @Override
    public String[] startGame() {
        return new String[] {
                "Welcome to Eri's World Stars Drag Race.\n",
                "This is a car race, not THAT race you found in Google!\n"
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
        return "What's the size of the strip?";
    }

    @Override
    public String kamikaze() {
        return "Would you like to play KAMIKAZE mode? Yes or No";
    }

    @Override
    public String start() {
        return "Let the race start!\n";
    }

    @Override
    public String[] carMake() {
        return new String[] {
                "Please enter the car you are driving",
                "What's the car make?"
        };
    }

    @Override
    public String carModel() {
        return "What's the car model?";
    }

    @Override
    public String carYear() {
        return "What's the car year?";
    }

    @Override
    public String carColor() {
        return "What's the car color?";
    }

    @Override
    public String typeEngine() {
        return "What's the car Engine type? (Electric, Hybrid, Ice)";
    }

    @Override
    public String invalidChoice() {
        return "Invalid choice, please try again";
    }

    @Override
    public String carMaxSpeed() {
        return "What's the car max speed?";
    }

    @Override
    public String[] invalidMax() {
        return new String[] {
                "Invalid max speed, don't lie, your car cannot go that fast!",
                "Setting car max speed to 300"
        };
    }

    @Override
    public String kamikazeOn() {
        return "\nKamikaze Mode is ON!\n";
    }

    @Override
    public String win(Player currentPlayer, int pass) {
        return currentPlayer.getName() + " Won!! It " +
                "took " + pass + " turns. Your speed was " + currentPlayer.getCurrentSpeed() + ". " +
                "Congratulations little burned rubber head";
    }


    @Override
    public String engineOn(Player currentPlayer) {
        return currentPlayer.getName() + " Is your car's " + "engine on? " + currentPlayer.getEngineStatus();
    }

    @Override
    public String turnOn() {
        return "Press any key turn it on/off";
    }

    @Override
    public String[] outGas(Player currentPlayer) {
        return new String[] {
                currentPlayer.getName() +  " ran out of gas",
                "These are your options:",
                "2 - Cruise",
                "3 - Brake",
                "What will you do?"
        };
    }


    @Override
    public String[] gasInfo(Player currentPlayer) {
        return new String[] {
                "It's " + currentPlayer.getName() + "\'s turn, " + "currently you have " +
                        currentPlayer.getGas() + " gas left in your tank",
                "These are your options:",
                "1 - Accelerate",
                "2 - Cruise",
                "3 - Brake",
                "What will you do?"
        };
    }

    @Override
    public String[] wallIntro(int wallOfDoom) {
        return new String[] {
                "Let's see if you are a REAL KAMIKAZE!",
                "The KAMIKAZE wall is " + wallOfDoom + " in front of you",
                "Are you ready?"
        };
    }

    @Override
    public String[] wallInfo(Player currentPlayer, int wallOfDoom) {
        return new String[] {
                currentPlayer.getName() + " you are driving at" + " " + currentPlayer.getCurrentSpeed(),
                "The KAMIKAZE wall is " + (wallOfDoom - currentPlayer.getLocation()) + " in front of you"
        };
    }

    @Override
    public String hitWall() {
        return "YOU HIT THE WALL AND COMPLETED YOUR KAMIKAZE MISSION!";
    }

    @Override
    public String safe() {
        return "Congratulations you stopped before hitting the wall";
    }

    @Override
    public String[] carInfo(Player currentPlayer) {
        return new String[] {
                "The winner's car:",
                "Car make: " + currentPlayer.getCarChoice().getMake(),
                "Model: " + currentPlayer.getCarChoice().getModel(),
                "Year:" + currentPlayer.getCarChoice().getYear() + " Color: " + currentPlayer.getCarChoice().getColor(),
                "Max speed: " + currentPlayer.getCarChoice().getMaxSpeed()
        };
    }

    @Override
    public String[] acceleMax(Car carChoice) {
        return new String[] {
                "You reached your car speed limit of " + carChoice.getMaxSpeed(),
                "You are cruising now."
        };
    }

    @Override
    public String displaySpeed(String name, int currentSpeed) {
        return name + " your speed is " + currentSpeed;
    }

    @Override
    public String acceleration(String name, int currentSpeed) {
        return name + " your speed is " + currentSpeed;
    }

    @Override
    public String cruise(String name) {
        return name + "is cruising and lost some speed due to drag.";
    }

    @Override
    public String cruiseDisplaySpeed(int currentSpeed) {
        return "Your speed is now: " + currentSpeed;
    }

    @Override
    public String stopped() {
        return "You are stopped";
    }

    @Override
    public String brake(String name, int currentSpeed) {
        return name + " slowed your speed to " + currentSpeed;
    }
}
