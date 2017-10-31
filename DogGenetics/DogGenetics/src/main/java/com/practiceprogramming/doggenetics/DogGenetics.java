/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.doggenetics;

import java.util.Random;

/**
 *
 * @author owner
 */
public class DogGenetics {

    public static void main(String[] args) {
        Random randomizer = new Random();

        System.out.print("What is your dog's name sir? ");
        System.out.println("Sir Fluffy McFlufferkins Esquire");

        System.out.println("Well then, I have this highly reliable report on Sir Fluffy McFlufferkins Esquire's prestigious background right here.");

        System.out.println("Sir Fluffy McFlufferkins Esquire is: ");

        int num1 = randomizer.nextInt(101);
        int num2 = randomizer.nextInt(101 - num1);
        int num3 = randomizer.nextInt(101 - num1 - num2);
        int num4 = randomizer.nextInt(101 - num1 - num2 - num3);
        int num5 = (100 - num1 - num2 - num3 - num4);

        System.out.println("St. Bernard " + num1);
        System.out.println("Poodle " + num2);
        System.out.println("Pomeranian " + num3);
        System.out.println("Chihuahua " + num4);
        System.out.println("Shih Tzu " + num5);

        System.out.println("Wow, thats QUITE a dog!");
    }

}
