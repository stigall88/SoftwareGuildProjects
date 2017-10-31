/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.dto;

/**
 *
 * @author owner
 */
public class Change {

    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int totalChange;

    public Change(int numOfPennies) {

        quarters = numOfPennies / 25;
        numOfPennies = numOfPennies - quarters * 25;

        dimes = numOfPennies / 10;
        numOfPennies = numOfPennies - dimes * 10;

        nickels = numOfPennies / 5;
        numOfPennies = numOfPennies - nickels * 5;

        pennies = numOfPennies / 1;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(int totalChange) {
        this.totalChange = totalChange;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.pennies;
        hash = 31 * hash + this.nickels;
        hash = 31 * hash + this.dimes;
        hash = 31 * hash + this.quarters;
        hash = 31 * hash + this.totalChange;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (this.pennies != other.pennies) {
            return false;
        }
        if (this.nickels != other.nickels) {
            return false;
        }
        if (this.dimes != other.dimes) {
            return false;
        }
        if (this.quarters != other.quarters) {
            return false;
        }
        if (this.totalChange != other.totalChange) {
            return false;
        }
        return true;
    }
    
    

}
