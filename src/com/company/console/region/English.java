package com.company.console.region;

import com.company.console.Language;
import com.company.player.Player;
import com.company.race.Lane;
import com.company.vehicle.type.Car;

public class English implements Language {

    @Override
    public String[] STARTGAME() {
        return new String[] {
                "Welcome to Eri's World Stars Drag Race.\n",
                "This is a car race, not THAT race you found at Google!\n",
                "Lets see if you can you find the bonus car!\n\n"
        };
    }

    @Override
    public String PLAYER_ONE() {
        return "Please enter first player name";
    }

    @Override
    public String PLAYER_TWO() {
        return "Please enter second player name";
    }

    @Override
    public String LANE_SIZE() {
        return "What's the size of the strip?";
    }

    @Override
    public String KAMIKAZE() {
        return "Would you like to play KAMIKAZE mode? Yes or No";
    }

    @Override
    public String START() {
        return "Let the race start!\n";
    }

    @Override
    public String[] CAR_MAKE() {
        return new String[] {
                "Please enter the car you are driving",
                "What's the car make?"
        };
    }

    @Override
    public String CAR_MODEL() {
        return "What's the car model?";
    }

    @Override
    public String CAR_YEAR() {
        return "What's the car year?";
    }

    @Override
    public String CAR_COLOR() {
        return "What's the car color?";
    }

    @Override
    public String BONUS() { return "Surprise! Hidden bonus car unlocked!"; }

    @Override
    public String TYPE_ENGINE() {
        return "What's the car Engine type? Select number 1 - Electric, 2 - Hybrid, 3 - Ice";
    }

    @Override
    public String INVALID_CHOICE() {
        return "Invalid choice, please try again";
    }

    @Override
    public String CAR_MAX_SPEED() {
        return "What's the car max speed?";
    }

    @Override
    public String[] INVALID_MAX() {
        return new String[] {
                "Invalid max speed, don't lie, your car cannot go that fast!",
                "Setting car max speed to 300"
        };
    }

    @Override
    public String KAMIKAZE_ON() {
        return "\nKamikaze Mode is ON!\n";
    }

    @Override
    public String WIN(Player currentPlayer, int pass) {
        return currentPlayer.getName() + " Won!! It " +
                "took " + pass + " turns. Your speed was " + currentPlayer.getCurrentSpeed() + ". " +
                "Congratulations little burned rubber head";
    }


    @Override
    public String ENGINE_ON(Player currentPlayer) {
        return currentPlayer.getName() + " Is your car's " + "engine on? " + currentPlayer.getEngineStatus();
    }

    @Override
    public String TURN_ON() {
        return "Press any key turn it on/off";
    }

    @Override
    public String LOCATION(Player currentPlayer, int laneSize) {
        return "You are at " + currentPlayer.getLocation() + " of " + laneSize;
    }

    @Override
    public String[] OUT_GAS(Player currentPlayer) {
        return new String[] {
                currentPlayer.getName() +  " ran out of gas",
                "These are your options:",
                "2 - Cruise",
                "3 - Brake",
                "What will you do?"
        };
    }

    @Override
    public String[] GAS_INFO(Player currentPlayer) {
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
    public String[] WALL_INTRO(int wallOfDoom) {
        return new String[] {
                "Let's see if you are a REAL KAMIKAZE!",
                "The KAMIKAZE wall is " + wallOfDoom + " in front of you",
                "Are you ready?"
        };
    }

    @Override
    public String[] WALL_INFO(Player currentPlayer, int wallOfDoom) {
        return new String[] {
                currentPlayer.getName() + " you are driving at" + " " + currentPlayer.getCurrentSpeed(),
                "The KAMIKAZE wall is " + (wallOfDoom - currentPlayer.getLocation()) + " in front of you"
        };
    }

    @Override
    public String HIT_WALL() {
        return "YOU HIT THE WALL AND COMPLETED YOUR KAMIKAZE MISSION!";
    }

    @Override
    public String SAFE() {
        return "Congratulations you stopped before hitting the wall";
    }

    @Override
    public String[] CAR_INFO(Player currentPlayer) {
        return new String[] {
                "The winner's car:",
                "Car make: " + currentPlayer.getCarChoice().getMake(),
                "Model: " + currentPlayer.getCarChoice().getModel(),
                "Year:" + currentPlayer.getCarChoice().getYear() + " Color: " + currentPlayer.getCarChoice().getColor(),
                "Max speed: " + currentPlayer.getCarChoice().getMaxSpeed()
        };
    }

    @Override
    public String[] ACCE_MAX(Car carChoice) {
        return new String[] {
                "You reached your car speed limit of " + carChoice.getMaxSpeed(),
                "You are cruising now."
        };
    }

    @Override
    public String DISPLAY_SPEED(String name, int currentSpeed) {
        return name + " your speed is " + currentSpeed;
    }

    @Override
    public String ACCELERATION(String name, int currentSpeed) {
        return name + " your speed is " + currentSpeed;
    }

    @Override
    public String CRUISE(String name) {
        return name + " is cruising and lost some speed due to drag.";
    }

    @Override
    public String CRUISE_DISPLAY_SPEED(int currentSpeed) {
        return "Your speed is now: " + currentSpeed;
    }

    @Override
    public String STOPPED() {
        return "You are stopped";
    }

    @Override
    public String BRAKE(String name, int currentSpeed) {
        return name + " slowed your speed to " + currentSpeed;
    }
}
