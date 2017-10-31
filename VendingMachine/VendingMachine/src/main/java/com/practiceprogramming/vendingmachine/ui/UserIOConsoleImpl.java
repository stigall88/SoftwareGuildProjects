/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class UserIOConsoleImpl implements UserIO {
    
     Scanner sc = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double num = 0;
        boolean isValid = false;
        while (!isValid) {
            String string = sc.nextLine();
            try {
                num = Double.parseDouble(string);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR");
                System.out.println(prompt);
            }
        }
        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double num = 0;
        boolean isValid = false;
        while (!isValid) {
            num = readDouble(prompt);
            if (num >= min && num <= max) {
                isValid = true;
            } else {
                print(prompt);
            }
        }
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float num = 0;
        boolean isValid = false;
        while (!isValid) {
            String string = sc.nextLine();
            try {
                num = Float.parseFloat(string);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR");
                System.out.println(prompt);
            }
        }
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float num = 0;
        boolean isValid = false;
        while (!isValid) {
            num = readFloat(prompt);
            if (num >= min && num <= max) {
                isValid = true;
            } else {
                print(prompt);
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int num = 0;
        boolean isValid = false;
        while (!isValid) {
            String string = sc.nextLine();
            try {
                num = Integer.parseInt(string);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR");
                System.out.println(prompt);
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int num = 0;
        boolean isValid = false;
        while (!isValid) {
            num = readInt(prompt);
            if (num >= min && num <= max) {
                isValid = true;
            } else {
                print(prompt);
            }
        }
        return num;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long num = 0;
        boolean isValid = false;
        while (!isValid) {
            String string = sc.nextLine();
            try {
                num = Long.parseLong(string);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("ERROR");
                System.out.println(prompt);
            }
        }
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long num = 0;
        boolean isValid = false;
        while (!isValid) {
            num = readLong(prompt);
            if (num >= min && num <= max) {
                isValid = true;
            } else {
                print(prompt);
            }
        }
        return num;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        BigDecimal value = null;
        boolean isValid = false;
        System.out.println(prompt);
        while(!isValid) {
            try {
                String userInput = sc.nextLine();
                value = new BigDecimal(userInput);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a BigDecimal");
            }
        }
        return value;

    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
