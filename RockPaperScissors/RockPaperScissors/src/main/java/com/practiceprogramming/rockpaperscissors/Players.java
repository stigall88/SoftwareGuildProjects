/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class Players {

    private int cpuChoice = 0;
    private int userChoice;

    Scanner playerChoice = new Scanner(System.in);

    public void cpuChoice() {
        Random randomChoice = new Random();

        cpuChoice = randomChoice.nextInt(3) + 1;

    }

    public void userChoice() {

        System.out.println("Make your selection (1)Rock (2)Paper (3)Scissors");
        
        userChoice = playerChoice.nextInt();
        if (userChoice < 1 || userChoice > 3 ) {
                System.out.println("Please enter valid selection of 1, 2, or 3!");
            }
        

    }

    public int getCpuChoice() {
        return cpuChoice;
    }

    public void setCpuChoice(int cpuChoice) {
        this.cpuChoice = cpuChoice;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public Scanner getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Scanner playerChoice) {
        this.playerChoice = playerChoice;
    }

}
