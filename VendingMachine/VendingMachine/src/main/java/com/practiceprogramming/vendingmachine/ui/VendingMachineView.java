/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.ui;

import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author owner
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("                                  ,'\\\n"
                + "    _.----.        ____         ,'  _\\   ___    ___     ____\n"
                + "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n"
                + "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n"
                + " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n"
                + "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n"
                + "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n"
                + "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n"
                + "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n"
                + "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n"
                + "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n"
                + "                                `'                            '-._|");
        io.print("Vending Machine");
        io.print("1.) Insert Change");
        io.print("2.) Make Purchase");
        io.print("3.) Return Change");
        io.print("4.) Exit");

        return io.readInt("Please make your selection", 1, 4);
    }

    //++++++++++++++++++++++ VIEW ITEMS ++++++++++++++++++++++
    public void viewItems(List<Item> itemList) {
        for (Item newItem : itemList) {
            if (newItem.getItemInventory() < 1) {
                io.print(newItem.getItemID() + "|" + " "
                        + "|" + newItem.getItemName() + " "
                        + "|" + "$" + newItem.getItemCost() + " "
                        + "|" + " OUT OF STOCK");
            } else {
                io.print(newItem.getItemID() + "|" + " "
                        + "|" + newItem.getItemName() + " "
                        + "|" + "$" + newItem.getItemCost() + " "
                        + "|" + newItem.getItemInventory());
            }
        }
        io.print("");
            io.readString("Please hit enter to continue");
    }

    public void displayViewItemsBanner() {
        io.print("========= Vending Machine Items =========");
    }

    public void insertChangeBanner() {
        io.print("==| INSERT CHANGE |==");
    }

    public BigDecimal insertChange() {
        BigDecimal userMoney = io.readBigDecimal("Please insert change");
        return userMoney;
    }

    public void displayMoneyInserted(BigDecimal userMoney) {
        io.print("You inserted $" + userMoney);
    }

    public String selectItem() {
        return io.readString("Please select an item by its 3-digit ID");
    }

    public void displayItemPurchased(Item item) {
        io.print("Enjoy your new " + item.getItemName() + ". Thank You!");
    }

    public void itemNotInstockBanner(Item item) {
        io.print("The following item " + item.getItemID() + "" + item.getItemName() + " is currently out of stock.");
    }

    public void currentBalance(BigDecimal changeNotReturned) {
        io.print("You have $" + changeNotReturned.toString() + " left to spend");
    }

    public void displayChange(Change change) {
        io.print("Here is your change: " + change.getQuarters() + " quarters "
                + change.getDimes() + " dimes " + change.getNickels() + " nickels "
                + change.getPennies() + " pennies");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("UNKNOWN COMMMAND");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
