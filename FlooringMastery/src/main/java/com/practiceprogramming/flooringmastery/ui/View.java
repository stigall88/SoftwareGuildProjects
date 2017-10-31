/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.ui;

import com.practiceprogramming.flooringmastery.dto.Order;
import com.practiceprogramming.flooringmastery.dto.Product;
import com.practiceprogramming.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author owner
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
                + " * *                       SouthPaw Flooring Co.                   * *\n"
                + " * *                                                               * *\n"
                + " * *                       1.) Display Orders                      * *\n"
                + " * *                       2.) Add Order                           * *\n"
                + " * *                       3.) Edit Order                          * *\n"
                + " * *                       4.) Remove Order                        * *\n"
                + " * *                       5.) Save Order                          * *\n"
                + " * *                       6.) Exit                                * *\n"
                + " * *                                                               * *\n"
                + " * *                                                               * *\n"
                + " * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("");
        return io.readInt("Please make a selection", 1, 6);
    }

    public LocalDate userInputDate() {
        return io.readLocalDate("Please enter the date you would like to search. ex. (MM/dd/yyyy)");
    }

    //+++++++++++++++++++++++++ DISPLAY ORDER BY DATE +++++++++++++++++++++++++
    public void displayOrdersByDate(List<Order> orderList, LocalDate date) {

        io.print("======= Orders for " + date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "=======");
        for (Order order : orderList) {
            io.print("Order #: " + order.getOrderIdNum() + " \n "
                    + "Customer: " + order.getCustomerName() + " \n "
                    + "State: " + order.getState() + " \n "
                    + "Tax: " + order.getStateTax() + " \n "
                    + "Product: " + order.getProductType() + " \n "
                    + "Area: " + order.getArea() + " \n "
                    + "Cost per Sq. Foot: " + order.getCostPerSqFoot() + " \n "
                    + "Labor Cost per Sq. Foot: " + order.getLaborCostPerSqFoot() + " \n "
                    + "Material Cost: " + order.getMaterialCost() + " \n "
                    + "Total Labor cost: " + order.getTotalLaborCost() + " \n "
                    + "Tax total: " + order.getTotalTax() + " \n "
                    + "Order total: " + order.getTotalCost());
        }

    }

    public Order getNewOrderInfo(List<Product> products, List<State> states) {

        Order newOrder = new Order();

        //get the date
        LocalDate date = io.readLocalDate("Please enter the date in this format MM-dd-yyyy");
        newOrder.setDate(date);

        //get user name
        boolean nameIsValid = false;

        while (!nameIsValid) {
            String userName = io.readString("Please enter the name for the order");

            if (userName.isEmpty() | userName.contains(",")) {
                io.print("Please enter a valid name for the customer");
            } else {
                newOrder.setCustomerName(userName);
                nameIsValid = true;
            }
        }

        io.print("");

        //get State
        boolean isValidState = false;

        displayAllStates(states);
        while (!isValidState) {
            String state = io.readString("Please enter your state. (ex. KY)");
            if (state.isEmpty()) {
                io.print("Invalid input! Please enter a valid state");
            } else {
                for (State newState : states) {
                    if (newState.getStateName().equalsIgnoreCase(state)) {
                        newOrder.setState(state);
                        newOrder.setStateTax(newState.getTaxRate());
                        isValidState = true;
                    }

                }
            }
        }

        io.print("");

        //get area
        boolean isValidArea = false;

        while (!isValidArea) {
            String area = io.readString("Please enter the area");
            if (area.isEmpty()) {
                io.print("Area must be a number in decimal format!");
            } else {
                BigDecimal newArea = new BigDecimal(area);
                newOrder.setArea(newArea);
                isValidArea = true;
            }
        }

        io.print("");

        //get product
        boolean isValidProduct = false;
        while (!isValidProduct) {
            viewProducts(products);
            String newProduct = io.readString("Please select the product type");
            if (newProduct.isEmpty() || newProduct == null) {
                io.print("Please enter a product from the list!");
            } else {
                for (Product product : products) {
                    if (product.getProductName().equalsIgnoreCase(newProduct)) {
                        newOrder.setProductType(newProduct);
                        newOrder.setCostPerSqFoot(product.getCostPerSqFt());
                        newOrder.setLaborCostPerSqFoot(product.getLaborCostPerSqFt());
                        isValidProduct = true;
                        io.print("");
                    }
                }
            }
        }

        return newOrder;
    }

    public void displayProductTypesBanner() {
        io.print("====== Product Types ======");
    }

    public void displayAddBanner() {
        io.print("========== Add Order ==========");
    }

    public void displayAddOrderSuccessBanner() {
        io.print("Order successfully added");
    }

    //+++++++++++++++++++++++++ DISPLAY ORDERS +++++++++++++++++++++++++
    public void displayOrderList(List<Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print("====================================================================");
            io.print("Order #: " + currentOrder.getOrderIdNum() + " \n "
                    + "Customer: " + currentOrder.getCustomerName() + " \n "
                    + "State: " + currentOrder.getState() + " \n "
                    + "Tax: " + currentOrder.getStateTax() + " \n "
                    + "Product: " + currentOrder.getProductType() + " \n "
                    + "Area: " + currentOrder.getArea() + " \n "
                    + "Cost per Sq. Foot: " + currentOrder.getCostPerSqFoot() + " \n "
                    + "Labor Cost per Sq. Foot: " + currentOrder.getLaborCostPerSqFoot() + " \n "
                    + "Material Cost: " + currentOrder.getMaterialCost() + " \n "
                    + "Total Labor cost: " + currentOrder.getTotalLaborCost() + " \n "
                    + "Tax total: " + currentOrder.getTotalTax() + " \n "
                    + "Order total: " + currentOrder.getTotalCost());
            io.print("====================================================================");
        }
        io.readString("Please hit enter to continue");
    }

    public List<Product> displayProducts(List<Product> productList) {
        return productList;
    }

    public void displayNewOrder(Order order) {
        io.print("====================================================================");
        io.print("Order #: " + order.getOrderIdNum() + " \n "
                + "Customer: " + order.getCustomerName() + " \n "
                + "State: " + order.getState() + " \n "
                + "Tax: " + order.getStateTax() + " \n "
                + "Product: " + order.getProductType() + " \n "
                + "Area: " + order.getArea() + " \n "
                + "Cost per Sq. Foot: " + order.getCostPerSqFoot() + " \n "
                + "Labor Cost per Sq. Foot: " + order.getLaborCostPerSqFoot() + " \n "
                + "Material Cost: " + order.getMaterialCost() + " \n "
                + "Total Labor cost: " + order.getTotalLaborCost() + " \n "
                + "Tax total: " + order.getTotalTax() + " \n "
                + "Order total: " + order.getTotalCost());
        io.print("====================================================================");
    }

    public void displayOrdersBanner() {
        io.print("========== Orders ==========");
    }

    public void viewProducts(List<Product> productList) {
        for (Product product : productList) {
            io.print(product.getProductName() + ", "
                    + product.getCostPerSqFt() + ", "
                    + product.getLaborCostPerSqFt());
        }
    }

    public void displayAllStates(List<State> stateList) {
        io.print("====== States ======");
        for (State state : stateList) {
            io.print(state.getStateName() + ", "
                    + state.getTaxRate());
        }

    }

    public int getorderIdNum() {
        int orderIdNum = 0;
        boolean isValid = false;
        while (!isValid) {
            orderIdNum = io.readInt("Please enter the Order ID #");
            if (orderIdNum < 1) {
                io.print("Please enter a valid Order ID #");
            } else {
                isValid = true;
            }
        }
        return orderIdNum;
    }

    //+++++++++++++++++++++++++ EDIT ORDER +++++++++++++++++++++++++

    public Order updatedOrder(List<Product> products, List<State> states, Order order) {

        Order newOrder = order;

        //get the date
//        LocalDate date = io.readLocalDate("Please enter the date in this format MM/dd/yyyy");
//        newOrder.setDate(date);

        //get user name
        boolean nameIsValid = false;

        while (!nameIsValid) {
            String userName = io.readString("Please enter the name for the order");
            if (userName.isEmpty() | userName.contains(",")) {
                io.print("Please enter a valid name for the customer");
            } else {
                newOrder.setCustomerName(userName);
                nameIsValid = true;
            }
        }

        //get State
        boolean isValidState = false;

        while (!isValidState) {

            displayAllStates(states);
            String state = io.readString("Please enter your state. (ex. KY)");
            if (state.isEmpty()) {
                io.print("Invalid input! Please enter a valid state");
            } else {
                for (State newState : states) {
                    if (newState.getStateName().equalsIgnoreCase(state)) {
                        newOrder.setState(state);
                        isValidState = true;
                    }
                }
            }
        }

        //get area
        boolean isValidArea = false;
        while (!isValidArea) {
            String area = io.readString("Please enter the area");
            if (area.isEmpty()) {
                io.print("Area must be a number in decimal format!");
            } else {
                BigDecimal newArea = new BigDecimal(area);
                newOrder.setArea(newArea);
                isValidArea = true;
            }
        }

        //get product
        boolean isValidProduct = false;
        while (!isValidProduct) {
            viewProducts(products);
            String newProduct = io.readString("Please select the product type");
            if (newProduct.isEmpty() || newProduct == null) {
                io.print("Please enter a product from the list!");
            } else {
                for (Product product : products) {
                    if (product.getProductName().equalsIgnoreCase(newProduct)) {
                        newOrder.setProductType(newProduct);
                        isValidProduct = true;
                    }
                }
            }
        }
        return newOrder;
    }

    public String getOrderIdChoice() {
        return io.readString("Please enter the Order ID # for the order you would like to update");
    }

    public String isDataCorrect() {
        return io.readString("Is all of the following data correct?");
    }

    public String askForDateBanner() {
        return io.readString("Please enter a date in the following format: MM/dd/yyyy");
    }

    //+++++++++++++++++++++++++ REMOVE ORDER +++++++++++++++++++++++++
    public void displayRemoveOrderBanner() {
        io.print("========== Remove Order ==========");
    }

    public String removeOrderConfirmation() {
        return io.readString("Are you sure you want to remove this order?");
    }

    //++++++++++++++++++++++ ERROR ++++++++++++++++++++++
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void invalidChoice() {
        io.print("Invalid Choice");
    }

    public void invalidOrder() {
        io.print("There is no order for that date...make sure you're entering the correct date.");
    }

    public void invalidProduct() {
        io.print("We do not have this product in our inventory. Please enter valid product.");
    }

    public void exitMessage() {
        io.print("You are now exiting.");
    }

    public LocalDate askForUserDate() {
        String date = io.readString("Please enter the date. (ex. MM-dd-yyyy)");
        LocalDate thisDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        if (thisDate != null) {
            return thisDate;
        } else {
            io.print("Invalid date format");
            return askForUserDate();
        }
    }

    public String getUserState() {
        String state = io.readString("Please enter the state");
        String userInput = state.toUpperCase();
        return userInput;
    }

    public Order getUserOrderInput(String name, String state, BigDecimal area, LocalDate date, String productName) {
        Order newOrder = new Order();
        newOrder.setDate(date);
        newOrder.setCustomerName(name);
        newOrder.setState(state);
        newOrder.setProductType(productName);
        newOrder.setArea(area);
        return newOrder;
    }

    public BigDecimal getArea() {
        return io.readBigDecimal("Please enter the area");
    }

    public BigDecimal getTaxRate() {
        return io.readBigDecimal("Please enter the tax rate for the state");
    }

    public int orderSaveConfirmation() {
        io.print("Please make your selection");
        io.print("1.) YES");
        io.print("2.) NO");
        return io.readInt("Are you sure you want to accept these changes?", 1, 2);
    }

    public int exitConfirmation() {
        io.print("Please make your selection");
        io.print("1.) YES");
        io.print("2.) NO");
        return io.readInt("Are you sure you would like to exit?", 1, 2);
    }

    public String confirmAddedOrder() {
        return io.readString("Please confirm this order. Would you like add this order? (Y) accept (N) return to Main Menu");
    }
    
    public void edited

//++++++++++++++++++++++ Banners ++++++++++++++++++++++
    public void displayEditOrderBanner() {
        io.print("========== Edit Order ==========");
    }

    public void displayStatesBanner() {
        io.print("========== States ==========");
    }

    public void displayOrderAddedSuccessBanner() {
        io.print("Order was sucessfuly created. Please hit enter to continue");
    }

    public void displayOrderNotCreatedBanner() {
        io.print("Order was not added. Please hit enter to continue.");
    }

    public void displayOrderRemoveSuccessBanner() {
        io.print("The order was successfully removed! Please hit enter to continue");
    }

    public void displayOrderNotRemovedBanner() {
        io.print("The order was not removed. Please hit enter to continue");
    }
    
    public void displayOrderEditedSuccessBanner() {
        io.print("The order was successfully edited. Please hit enter to continue");
    }
    
    public void displaySaveSuccessBanner() {
        io.print("Your progress has sucessfully been saved. Please hit enter to continue");
    }
    
    public void displayTrainingMode() {
        io.print("You are currently in training mode");
    }
    
    public void displayProdMode() {
        io.print("You are currently in production mode");
    }
    
    public void saveTrainingMode() {
        io.print("========== IN TRAINING MODE ==========");
        io.print("Sorry, progress can only be saved in Production Mode. Please hit enter to continue");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

}
