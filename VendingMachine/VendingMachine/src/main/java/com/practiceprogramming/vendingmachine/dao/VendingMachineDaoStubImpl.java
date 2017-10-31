/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.dao;

import com.practiceprogramming.vendingmachine.dto.Item;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineIdNotValidException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("000");
        onlyItem.setItemName("PokeBalls");
        onlyItem.setItemCost(new BigDecimal(2.25));
        onlyItem.setItemInventory(1);

        itemList.add(onlyItem);
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Item addItem(String itemIdNumber, Item item) throws VendingMachinePersistenceException {
        if (itemIdNumber.equals(onlyItem.getItemID())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item updateInventory(Item item, int itemInventory) throws VendingMachinePersistenceException {
        if (item.getItemInventory() >= 1) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item removeItem(String itemIdNumber) throws VendingMachinePersistenceException {
        if (itemIdNumber.equals(onlyItem.getItemID())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item getItem(String itemIdNumber) throws VendingMachinePersistenceException, VendingMachineIdNotValidException {
        if (itemIdNumber.equals(onlyItem.getItemID())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void readInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
