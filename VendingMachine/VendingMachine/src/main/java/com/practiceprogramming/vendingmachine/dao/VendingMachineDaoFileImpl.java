/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.dao;

import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineIdNotValidException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineInsufficientFundsException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineOutOfStockException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Item> vendingMachineItems = new HashMap<>();

    public static final String VEND_FILE = "items.txt";
    public static final String DELIMITER = "::";

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException{
        readInventory();
        return new ArrayList<>(vendingMachineItems.values());
    }

    @Override
    public Item addItem(String itemIdNumber, Item item) throws VendingMachinePersistenceException {
        readInventory();
        Item newItem = vendingMachineItems.put(item.getItemID(), item);
        writeInventory();
        return newItem;
    }

    @Override
    public Item getItem(String itemIdNumber) throws VendingMachinePersistenceException, VendingMachineIdNotValidException {
        readInventory();
        return vendingMachineItems.get(itemIdNumber);
    }

    @Override
    public Item removeItem(String itemIdNumber) throws VendingMachinePersistenceException {
        readInventory();
        Item removedItem = vendingMachineItems.remove(itemIdNumber);
        writeInventory();
        return removedItem;
    }

    @Override
    public void readInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VEND_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load item data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Item item = new Item(currentTokens[0]);
            item.setItemName(currentTokens[1]);
            item.setItemCost(new BigDecimal(currentTokens[2]));
            item.setItemInventory(Integer.parseInt(currentTokens[3]));
            vendingMachineItems.put(item.getItemID(), item);
        }
        scanner.close();
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VEND_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }

        List<Item> items = this.getAllItems();
        for (Item newItem : items) {
            out.println(newItem.getItemID() + DELIMITER
                    + newItem.getItemName() + DELIMITER
                    + newItem.getItemCost() + DELIMITER
                    + newItem.getItemInventory());
            out.flush();
        }
        out.close();
    }

//    @Override
//    public Item updateInventory(Item item, int itemInventory)  throws VendingMachineDaoException{
//        readInventory();
//        int inventory = item.getItemInventory() - 1;
//        Item newItem = vendingMachineItems.put(item.getItemID(), item);
//        writeInventory();
//        return newItem;
//    }
    @Override
    public Item updateInventory(Item item, int itemInventory) throws VendingMachinePersistenceException{
        itemInventory = item.getItemInventory();
        item.setItemInventory(itemInventory - 1);
        Item newItem = vendingMachineItems.put(item.getItemID(), item);
        writeInventory();
        return newItem;
    }

}
