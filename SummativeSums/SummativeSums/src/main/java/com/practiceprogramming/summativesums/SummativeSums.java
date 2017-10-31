/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.summativesums;

/**
 *
 * @author owner
 */
public class SummativeSums {

    public static void main(String[] args) {

        int myArray1[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int myArray2[] = {999, -60, -77, 14, 160, 301};
        int myArray3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};

        int sum1 = sumOfArrays(myArray1);
        int sum2 = sumOfArrays(myArray2);
        int sum3 = sumOfArrays(myArray3);

        System.out.println("#1 Array sum: " + sum1);
        System.out.println("#2 Array sum: " + sum2);
        System.out.println("#3 Array sum: " + sum3);

    }

    public static int sumOfArrays(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;

        }
        return sum;

    }

}
