package com.company.console.region;

import com.company.console.Language;
import com.company.player.Player;
import com.company.vehicle.type.Car;

public class Portuguese implements Language {

    @Override
    public String[] STARTGAME() {
        return new String[] {
                "Bem vindo a corrida de drag do Eri.\n",
                "Isso é uma corrida de carros, não aquilo que você achou no Google!\n",
                "\nSera que você consegue encontrar o carro bonus?\n"
        };
    }

    @Override
    public String PLAYER_ONE() {
        return "Por favor entre o nome do primeiro jogador.";
    }

    @Override
    public String PLAYER_TWO() {
        return "Por favor entre o nome do segundo jogador.";
    }

    @Override
    public String LANE_SIZE() {
        return "Qual o tamanho da pista?";
    }

    @Override
    public String KAMIKAZE() {
        return "Você quer jogar o modo KAMIKAZE? Yes ou No";
    }

    @Override
    public String START() {
        return "Que começe a corrida!\n";
    }

    @Override
    public String[] CAR_MAKE() {
        return new String[] {
                "Por favor entre o carro que você esta dirigindo.",
                "Qual é a marca do carro?"
        };
    }

    @Override
    public String CAR_MODEL() {
        return "Qual é o modelo do carro?";
    }

    @Override
    public String CAR_YEAR() {
        return "Qual é o ano do carro?";
    }

    @Override
    public String CAR_COLOR() {
        return "Qual é a cor?";
    }

    @Override
    public String BONUS() { return "Surpresa! Carro bonus escondido " +
            "destravado!"; }

    @Override
    public String TYPE_ENGINE() {
        return "Qual é o tipo do motor? Selecione o número 1- Eletrico 2 - Hibrido 3 - Combustão)";
    }

    @Override
    public String INVALID_CHOICE() {
        return "Escolha invalida, por favor tente novamente.";
    }

    @Override
    public String CAR_MAX_SPEED() {
        return "Qual é a velocidade máxima do seu carro?";
    }

    @Override
    public String[] INVALID_MAX() {
        return new String[] {
                "Velocidade máxima invalida, não minta, seu carro não consegue ir tão rápido!",
                "Ajustando velocidade máxima para 300"
        };
    }

    @Override
    public String KAMIKAZE_ON() {
        return "\nModo Kamikaze LIGADO!\n";
    }

    @Override
    public String WIN(Player currentPlayer, int pass) {
        return currentPlayer.getName() + " Venceu!! Usou " + pass + " turnos. Sua velocidade foi " + currentPlayer.getCurrentSpeed() + ". " +
                "Parabens cabeça de borracha queimada.";
    }


    @Override
    public String ENGINE_ON(Player currentPlayer) {
        return currentPlayer.getName() + " O motor do seu carro esta ligado? " + currentPlayer.getEngineStatus();
    }

    @Override
    public String TURN_ON() {
        return "Aperte qualquer tecla para ligar ou desligar o carro.";
    }

    @Override
    public String LOCATION(Player currentPlayer, int laneSize) {
        return "Voce esta a " + currentPlayer.getLocation() + " de " + laneSize;
    }

    @Override
    public String[] OUT_GAS(Player currentPlayer) {
        return new String[] {
                currentPlayer.getName() +  "está sem gasolina",
                "Essas são suas opções:",
                "2 - Soltar",
                "3 - Freiar",
                "O que você vai fazer?"
        };
    }


    @Override
    public String[] GAS_INFO(Player currentPlayer) {
        return new String[] {
                "É a vez do " + currentPlayer.getName() + " você tem " +
                        currentPlayer.getGas() + " de gasolina ainda no tanque.",
                "Essas são suas opções:",
                "1 - Acelerar",
                "2 - Soltar",
                "3 - Freiar",
                "O que você vai fazer?"
        };
    }

    @Override
    public String[] WALL_INTRO(int wallOfDoom) {
        return new String[] {
                "Vamos ver se você é um verdadeiro KAMIKAZE!",
                "A muralha KAMIKAZE está a " + wallOfDoom + " na sua frente",
                "Você esta pronto?"
        };
    }

    @Override
    public String[] WALL_INFO(Player currentPlayer, int wallOfDoom) {
        return new String[] {
                currentPlayer.getName() + " você esta dirigindo a " + currentPlayer.getCurrentSpeed(),
                "A muralha KAMIKAZE está a " + (wallOfDoom - currentPlayer.getLocation()) + " na sua frente"
        };
    }

    @Override
    public String HIT_WALL() {
        return "VOCÊ ACERTOU A MURALHA KAMIKAZE E COMPLETOU SUA MISSÃO!";
    }

    @Override
    public String SAFE() {
        return "Parabéns você parou antes de acertar a muralha KAMIKAZE.";
    }

    @Override
    public String[] CAR_INFO(Player currentPlayer) {
        return new String[] {
                "O carro vencedor:",
                "Marca: " + currentPlayer.getCarChoice().getMake(),
                "Modelo: " + currentPlayer.getCarChoice().getModel(),
                "Ano:" + currentPlayer.getCarChoice().getYear() + " Cor: " + currentPlayer.getCarChoice().getColor(),
                "Velocidade máxima: " + currentPlayer.getCarChoice().getMaxSpeed()
        };
    }

    @Override
    public String[] ACCE_MAX(Car carChoice) {
        return new String[] {
                "Você chegou na velocidade máxima de " + carChoice.getMaxSpeed(),
                "Você está na \"banguela\"."
        };
    }

    @Override
    public String DISPLAY_SPEED(String name, int currentSpeed) {
        return name + " sua velocidade é " + currentSpeed;
    }

    @Override
    public String ACCELERATION(String name, int currentSpeed) {
        return name + " sua velocidade é " + currentSpeed;
    }

    @Override
    public String CRUISE(String name) {
        return name + "está na banguela e perdeu um pouco de velocidade devido ao arrasto.";
    }

    @Override
    public String CRUISE_DISPLAY_SPEED(int currentSpeed) {
        return "Sua velocidade atual: " + currentSpeed;
    }

    @Override
    public String STOPPED() {
        return "Você está parado.";
    }

    @Override
    public String BRAKE(String name, int currentSpeed) {
        return name + " diminuiu a velocidade para " + currentSpeed;
    }
}
