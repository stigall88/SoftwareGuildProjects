/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author owner
 */
public class RockPaperScissorsGame {

    Players user;
    Players cpu;
    int rock = 1;
    int paper = 2;
    int scissors = 3;
    int userScore = 0;
    int cpuScore = 0;
    int tie = 0;
    int round;
    boolean playAgain = true;
    int userRound;

    public void startGame() {

        Scanner sc = new Scanner(System.in);

        user = new Players();
        cpu = new Players();
        
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("*      Rock, Paper, Scissors    *");
        System.out.println("*                               *");
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println();
        sc.nextLine();
        System.out.println("    _______\n" +
                           "---'   ____)\n" +
                           "      (_____)\n" +
                           "      (_____)\n" +
                           "      (____)\n" +
                           "---.__(___)");
        sc.nextLine();
        System.out.println("    _______\n" +
                           "---'   ____)____\n" +
                           "          ______)\n" +
                           "          _______)\n" +
                           "         _______)\n" +
                           "---.__________)");
        sc.nextLine();
        System.out.println("    _______\n" +
                           "---'   ____)____\n" +
                           "          ______)\n" +
                           "       __________)\n" +
                           "      (____)\n" +
                           "---.__(___)");
        
        

        while (playAgain) {
            
            System.out.println();
            System.out.println("How many rounds would you like to play?");
            userRound = sc.nextInt();
            System.out.println();

            if (userRound < 1 || userRound > 10) {
                System.out.println("Please enter a number between 1 and 10!");
            }
            
            

            for (int i = 1; i <= userRound; i++) {
                user.userChoice();
                cpu.cpuChoice();
                if (user.getUserChoice() == rock && cpu.getCpuChoice() == rock) {
                    System.out.println("You both chose Rock so the result is a TIE");
                    tie++;
                } else if (user.getUserChoice() == rock && cpu.getCpuChoice() == paper) {
                    System.out.println("    _______\n" +
                                       "---'   ____)____\n" +
                                       "          ______)\n" +
                                       "          _______)\n" +
                                       "         _______)\n" +
                                       "---.__________)");
                    System.out.print(" covers Rock...CPU wins this one!");
                    cpuScore++;
                } else if (user.getUserChoice() == rock && cpu.getCpuChoice() == scissors) {
                    System.out.println("    _______\n" +
                                       "---'   ____)\n" +
                                       "      (_____)\n" +
                                       "      (_____)\n" +
                                       "      (____)\n" +
                                       "---.__(___)");
                    System.out.print(" crushes Scissors...User wins this one!");
                    userScore++;
                } else if (user.getUserChoice() == paper && cpu.getCpuChoice() == rock) {
                    System.out.println("    _______\n" +
                                       "---'   ____)____\n" +
                                       "          ______)\n" +
                                       "          _______)\n" +
                                       "         _______)\n" +
                                       "---.__________)");
                    System.out.print(" covers Rock...User wins this one!");
                    userScore++;
                } else if (user.getUserChoice() == paper && cpu.getCpuChoice() == paper) {
                    System.out.println("You both chose Paper so the result is a TIE");
                    tie++;
                } else if (user.getUserChoice() == paper && cpu.getCpuChoice() == scissors) {
                    System.out.println("    _______\n" +
                                       "---'   ____)____\n" +
                                       "          ______)\n" +
                                       "       __________)\n" +
                                       "      (____)\n" +
                                       "---.__(___)");
                    System.out.print(" cut Paper....CPU wins!");
                    cpuScore++;
                } else if (user.getUserChoice() == scissors && cpu.getCpuChoice() == rock) {
                    System.out.println("    _______\n" +
                                       "---'   ____)\n" +
                                       "      (_____)\n" +
                                       "      (_____)\n" +
                                       "      (____)\n" +
                                       "---.__(___)");
                    System.out.print(" crushes Scissors...CPU wins this one!");
                    cpuScore++;
                } else if (user.getUserChoice() == scissors && cpu.getCpuChoice() == paper) {
                      System.out.println("    _______\n" +
                                         "---'   ____)____\n" +
                                         "          ______)\n" +
                                         "       __________)\n" +
                                         "      (____)\n" +
                                         "---.__(___)");
                    System.out.print(" cut Paper....User wins!");
                    userScore++;
                } else if (user.getUserChoice() == scissors && cpu.getCpuChoice() == scissors) {
                    System.out.println("You both chose Scissors so the result is a TIE!");
                    tie++;
                }

                System.out.println();
            }

            System.out.println("User Score: " + userScore);
            System.out.println("CPU Score: " + cpuScore);
            System.out.println("Ties: " + tie);

            System.out.println();

            System.out.println("Would you like to play again?");
            sc.nextLine();
            String playAgainString = sc.nextLine();

            System.out.println();

            if (playAgainString.equalsIgnoreCase("N")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
                break;

            } else {
                userScore = 0;
                cpuScore = 0;
                tie = 0;
            }

        }

    }

}
