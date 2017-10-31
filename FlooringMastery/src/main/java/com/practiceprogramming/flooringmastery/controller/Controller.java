/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.controller;

import com.practiceprogramming.flooringmastery.dao.FlooringPersistenceException;
import com.practiceprogramming.flooringmastery.dto.Order;
import com.practiceprogramming.flooringmastery.dto.Product;
import com.practiceprogramming.flooringmastery.dto.State;
import com.practiceprogramming.flooringmastery.service.InvalidOrderDateException;
import com.practiceprogramming.flooringmastery.service.ServiceLayer;
import com.practiceprogramming.flooringmastery.ui.View;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author owner
 */
public class Controller {

    private View view;
    private ServiceLayer service;

    public Controller(View view, ServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            
            service.load();
            while (keepGoing) {
                boolean isConfigMode = service.isConfigMode();
                if(isConfigMode) {
                    view.displayTrainingMode();
                } else {
                    view.displayProdMode();
                }
                menuSelection = getMenuAndSelection();
                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        if (isConfigMode) {
                            view.saveTrainingMode();
                        } else {
                        saveOrder();
                        }
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (FlooringPersistenceException | InvalidOrderDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuAndSelection() {
        return view.printMenuAndGetSelection();
    }

    //++++++++++++++++++++ DISPLAY ORDERS ++++++++++++++++++++
    private void displayOrders() throws FlooringPersistenceException {
        view.displayOrdersBanner();
        LocalDate date = view.askForUserDate();
        try {
            List<Order> orderList = service.getOrdersByDate(date);
            view.displayOrderList(orderList);
        } catch (InvalidOrderDateException e) {
            view.displayErrorMessage("There are no orders for that date ");
        }
    }

    //++++++++++++++++++++ ADD ORDERS ++++++++++++++++++++
    private void addOrder() throws FlooringPersistenceException {

        view.displayAddBanner();
        List<State> state = service.getAllStates();
        List<Product> products = service.getAllProducts();

        Order newOrder = view.getNewOrderInfo(products, state);
        Order newOrder1 = service.completeOrder(newOrder);

        int orderIdNum = service.getNextIdNum();
        newOrder1.setOrderIdNum(orderIdNum);

        view.displayNewOrder(newOrder1);
        String confirm = view.confirmAddedOrder();
        if (confirm.equalsIgnoreCase("Y")) {
            service.addOrder(newOrder1.getOrderIdNum(), newOrder1);
            view.displayOrderAddedSuccessBanner();
        } else {
            view.displayOrderNotCreatedBanner();
        }

    }

    //++++++++++++++++++++ EDIT ORDERS ++++++++++++++++++++
    private void editOrder() throws InvalidOrderDateException {
        view.displayEditOrderBanner();
        LocalDate date = view.askForUserDate();
        int orderId = view.getorderIdNum();
        Order editedOrder = service.getOrder(orderId, date);
        List<State> states = service.getAllStates();
        List<Product> products = service.getAllProducts();
        Order newOrder = view.updatedOrder(products, states, editedOrder);
        newOrder = service.completeOrder(newOrder);
        service.addOrder(newOrder.getOrderIdNum(), newOrder);
        view.displayOrderEditedSuccessBanner();
    }

    //++++++++++++++++++++ REMOVE ORDERS ++++++++++++++++++++
    private void removeOrder() throws FlooringPersistenceException {
        view.displayRemoveOrderBanner();
        
       
            LocalDate date = view.askForUserDate();
            int orderIdNum = view.getorderIdNum();
            
            String confirm = view.removeOrderConfirmation();
            if (confirm.equalsIgnoreCase("Y")) {
                service.removeOrder(orderIdNum);
                view.displayOrderRemoveSuccessBanner();
            }
   
    }
    
    //++++++++++++++++++++ SAVE ORDERS ++++++++++++++++++++

    private void saveOrder() throws FlooringPersistenceException {
        service.save();
        view.displaySaveSuccessBanner();
    }

    public void listAllStates() {
        view.displayStatesBanner();
        List<State> stateList = service.getAllStates();
        view.displayAllStates(stateList);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.exitMessage();
    }

}
