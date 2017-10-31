/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.servicelayer;

import com.practiceprogramming.vendingmachine.dao.VendingMachineAuditDao;
import com.practiceprogramming.vendingmachine.dao.VendingMachineDao;
import com.practiceprogramming.vendingmachine.dao.VendingMachinePersistenceException;
import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author owner
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    private BigDecimal userMoney = new BigDecimal(0);

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public BigDecimal changeInserted(BigDecimal insertedMoney) throws VendingMachinePersistenceException, VendingMachineInvalidChangeInputException {
        if (insertedMoney.compareTo(new BigDecimal(0)) <= 0) {
            throw new VendingMachineInvalidChangeInputException("Stop being stupid and insert a valid change amount!");
        } else {
            userMoney = userMoney.add(insertedMoney);
        }
        return userMoney;
    }

    @Override
    public Change returnChange() throws VendingMachinePersistenceException {
        Integer numOfPennies = userMoney.multiply(new BigDecimal(100)).intValue();
        Change newChange = new Change(numOfPennies);
        userMoney = new BigDecimal("0");
        return newChange;
    }

    @Override
    public Item purchaseItem(Item item) throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException,
            VendingMachineOutOfStockException {
        if (item.getItemInventory() <= 0) {
            throw new VendingMachineOutOfStockException("Sorry this item is not instock. Please make another selection");
        } else if (userMoney.compareTo(item.getItemCost()) < 0) {
            throw new VendingMachineInsufficientFundsException("You need more money for this item. Please add more change!");
        } else {
            userMoney = userMoney.subtract(item.getItemCost());
            dao.updateInventory(item, -1);
        }
        return item;
    }

    @Override
    public BigDecimal changeBalance() {
        return userMoney;
    }

    @Override
    public Item getItem(String itemIdNumber) throws VendingMachinePersistenceException, VendingMachineIdNotValidException,
            VendingMachineOutOfStockException {
        //readInventory();
        if (dao.getItem(itemIdNumber) == null) {
            throw new VendingMachineIdNotValidException("Sorry that is not a valid ID. Please try again.");
        } else if (dao.getItem(itemIdNumber).getItemInventory() <= 0) {
            throw new VendingMachineOutOfStockException("That item is out of stock. Make a different selection.");
        } 
        return dao.getItem(itemIdNumber);
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        //readInventory();
        return dao.getAllItems();
    }

}
