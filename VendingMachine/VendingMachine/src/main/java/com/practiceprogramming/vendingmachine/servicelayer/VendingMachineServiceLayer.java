/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.servicelayer;

import com.practiceprogramming.vendingmachine.dao.VendingMachinePersistenceException;
import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author owner
 */
public interface VendingMachineServiceLayer {

    BigDecimal changeInserted(BigDecimal userMoney) throws VendingMachinePersistenceException, VendingMachineInvalidChangeInputException;

    Change returnChange() throws VendingMachinePersistenceException;

    Item purchaseItem(Item item) throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException,
            VendingMachineOutOfStockException;

    BigDecimal changeBalance() throws VendingMachinePersistenceException;

    public Item getItem(String itemIdNumber) throws VendingMachinePersistenceException, VendingMachineIdNotValidException, VendingMachineOutOfStockException;
    
    public List<Item> getAllItems() throws VendingMachinePersistenceException;
    
}
