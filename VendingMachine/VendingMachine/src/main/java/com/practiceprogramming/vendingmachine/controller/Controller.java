/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.controller;

import com.practiceprogramming.vendingmachine.dao.VendingMachinePersistenceException;
import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineIdNotValidException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineInsufficientFundsException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineInvalidChangeInputException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineOutOfStockException;
import com.practiceprogramming.vendingmachine.servicelayer.VendingMachineServiceLayer;
import com.practiceprogramming.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author owner
 */
public class Controller {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public Controller(VendingMachineView view, VendingMachineServiceLayer service
    ) {
        this.view = view;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;
        try {

            while (keepGoing) {
                listItems();
                menuSelection = getMenuSelection();
                switch (menuSelection) {

                    case 1:
                        insertChange();
                        break;
                    case 2:
                        makePurchase();
                        break;
                    case 3:
                        returnChange();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException | VendingMachineIdNotValidException
                | VendingMachineInsufficientFundsException | VendingMachineInvalidChangeInputException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void insertChange() throws VendingMachinePersistenceException, 
            VendingMachineInvalidChangeInputException {
        try {
        view.insertChangeBanner();
        BigDecimal userMoney = view.insertChange();
        BigDecimal totalChange = service.changeInserted(userMoney);
        view.displayMoneyInserted(userMoney);
        } catch (VendingMachineInvalidChangeInputException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void listItems() throws VendingMachinePersistenceException {
        view.displayViewItemsBanner();
        List<Item> itemList = service.getAllItems();
        view.viewItems(itemList);
    }

    private void makePurchase() throws VendingMachinePersistenceException, VendingMachineIdNotValidException,
            VendingMachineInvalidChangeInputException, VendingMachineInsufficientFundsException {
        List<Item> itemList = service.getAllItems();
        String itemId = view.selectItem();

        try {
            Item newItem = service.getItem(itemId);
            newItem = service.purchaseItem(newItem);

            view.displayItemPurchased(newItem);
            BigDecimal balance = service.changeBalance();
            view.currentBalance(balance);
        } catch (VendingMachineInsufficientFundsException | VendingMachineOutOfStockException | VendingMachineIdNotValidException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void returnChange() throws VendingMachinePersistenceException {
        Change change = service.returnChange();
        view.displayChange(change);
    }
}
