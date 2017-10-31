/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.healthyhearts;

import java.util.Scanner;

/**
 *
 * @author owner
 */
public class HealthyHearts {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Scanner will take users input of age in as an int
        System.out.println("Please provide your age: ");
        int age = input.nextInt();

        //Declare variables
        double maxHeart = (220.0 - age);
        double minTarget = (maxHeart * 0.50);
        double maxTarget = (maxHeart * 0.85);

        //Math.round to round up to the closest integer otherwise it will produce a decimal
        System.out.println("Your maximum heart rate should be " + Math.round(maxHeart));
        System.out.println("Your target HR Zone is " + Math.round(minTarget) + " - " + Math.round(maxTarget));

    }

}
