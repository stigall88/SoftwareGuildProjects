/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.dao;

import com.practiceprogramming.vendingmachine.dto.Item;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineIdNotValidException;
import java.util.List;

/**
 *
 * @author owner
 */
public interface VendingMachineDao {
    
    List<Item> getAllItems() throws VendingMachinePersistenceException;
    
    Item addItem(String itemIdNumber, Item item) throws VendingMachinePersistenceException;
    
    Item updateInventory(Item item, int itemInventory) throws VendingMachinePersistenceException;
    
    Item removeItem(String itemIdNumber) throws VendingMachinePersistenceException;
    
    Item getItem(String itemIdNumber) throws VendingMachinePersistenceException, VendingMachineIdNotValidException;
    
    //Item updateInventory(Item item, int itemInventory) throws VendingMachineDaoException;
    
    void readInventory() throws VendingMachinePersistenceException;
    
    void writeInventory() throws VendingMachinePersistenceException;
    
    //Service Layer Methods
    
   
}
