package com.company.console.region;

import com.company.console.Language;
import com.company.player.Player;
import com.company.vehicle.type.Car;

public class Portuguese implements Language {

    @Override
    public String[] startGame() {
        return new String[] {


                "Bem vindo a corrida de drag do Eri.\n",
                "Isso é uma corrida de carros, não aquilo que você achou no Google!\n"
        };
    }

    @Override
    public String playerOne() {
        return "Por favor entre o nome do primeiro jogador.";
    }

    @Override
    public String playerTwo() {
        return "Por favor entre o nome do segundo jogador.";
    }

    @Override
    public String laneSize() {
        return "Qual o tamanho da pista?";
    }

    @Override
    public String kamikaze() {
        return "Você quer jogar o modo KAMIKAZE? Yes ou No";
    }

    @Override
    public String start() {
        return "Que começe a corrida!\n";
    }

    @Override
    public String[] carMake() {
        return new String[] {
                "Por favor entre o carro que você esta dirigindo.",
                "Qual é a marca do carro?"
        };
    }

    @Override
    public String carModel() {
        return "Qual é o modelo do carro?";
    }

    @Override
    public String carYear() {
        return "Qual é o ano do carro?";
    }

    @Override
    public String carColor() {
        return "Qual é a cor?";
    }

    @Override
    public String typeEngine() {
        return "Qual é o tipo do motor? (Electric, Hybrid, Ice)";
    }

    @Override
    public String invalidChoice() {
        return "Escolha invalida, por favor tente novamente.";
    }

    @Override
    public String carMaxSpeed() {
        return "Qual é a velocidade máxima do seu carro?";
    }

    @Override
    public String[] invalidMax() {
        return new String[] {
                "Velocidade máxima invalida, não minta, seu carro não consegue ir tão rápido!",
                "Ajustando velocidade máxima para 300"
        };
    }

    @Override
    public String kamikazeOn() {
        return "\nModo Kamikaze LIGADO!\n";
    }

    @Override
    public String win(Player currentPlayer, int pass) {
        return currentPlayer.getName() + " Venceu!! Usou " + pass + " turnos. Sua velocidade foi " + currentPlayer.getCurrentSpeed() + ". " +
                "Parabens cabeça de borracha queimada.";
    }


    @Override
    public String engineOn(Player currentPlayer) {
        return currentPlayer.getName() + " O motor do seu carro esta ligado? " + currentPlayer.getEngineStatus();
    }

    @Override
    public String turnOn() {
        return "Aperte qualquer tecla para ligar ou desligar o carro.";
    }

    @Override
    public String[] outGas(Player currentPlayer) {
        return new String[] {
                currentPlayer.getName() +  "está sem gasolina",
                "Essas são suas opções:",
                "2 - Soltar",
                "3 - Freiar",
                "O que você vai fazer?"
        };
    }


    @Override
    public String[] gasInfo(Player currentPlayer) {
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
    public String[] wallIntro(int wallOfDoom) {
        return new String[] {
                "Vamos ver se você é um verdadeiro KAMIKAZE!",
                "A muralha KAMIKAZE está a " + wallOfDoom + " na sua frente",
                "Você esta pronto?"
        };
    }

    @Override
    public String[] wallInfo(Player currentPlayer, int wallOfDoom) {
        return new String[] {
                currentPlayer.getName() + " você esta dirigindo a " + currentPlayer.getCurrentSpeed(),
                "A muralha KAMIKAZE está a " + (wallOfDoom - currentPlayer.getLocation()) + " na sua frente"
        };
    }

    @Override
    public String hitWall() {
        return "VOCÊ ACERTOU A MURALHA KAMIKAZE E COMPLETOU SUA MISSÃO!";
    }

    @Override
    public String safe() {
        return "Parabéns você parou antes de acertar a muralha KAMIKAZE.";
    }

    @Override
    public String[] carInfo(Player currentPlayer) {
        return new String[] {
                "O carro vencedor:",
                "Marca: " + currentPlayer.getCarChoice().getMake(),
                "Modelo: " + currentPlayer.getCarChoice().getModel(),
                "Ano:" + currentPlayer.getCarChoice().getYear() + " Cor: " + currentPlayer.getCarChoice().getColor(),
                "Velocidade máxima: " + currentPlayer.getCarChoice().getMaxSpeed()
        };
    }

    @Override
    public String[] acceleMax(Car carChoice) {
        return new String[] {
                "Você chegou na velocidade máxima de " + carChoice.getMaxSpeed(),
                "Você está na \"banguela\"."
        };
    }

    @Override
    public String acceleration(String name, int currentSpeed) {
        return name + " sua velocidade é " + currentSpeed;
    }

    @Override
    public String[] cruise(String name) {
        return new String[] {
                name + "está na banguela e perdeu um pouco de velocidade devido ao arrasto."
        };
    }

    @Override
    public String stopped() {
        return "Você está parado.";
    }

    @Override
    public String brake(String name, int currentSpeed) {
        return name + " diminuiu a velocidade para " + currentSpeed;
    }
}
