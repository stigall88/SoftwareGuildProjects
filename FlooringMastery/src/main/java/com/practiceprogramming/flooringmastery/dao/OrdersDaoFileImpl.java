/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author owner
 */
public class OrdersDaoFileImpl implements OrdersDao {

    private Map<Integer, Order> orders = new HashMap<>();

    public static final String ORDERS_FOLDER = "./Orders/";
    private int orderId = 0;
    public static final String DELIMITER = ",";
    private List<LocalDate> dates = new ArrayList<>();
    
     @Override
    public int load() throws FlooringPersistenceException {
        
        Scanner scanner;

        File folder = new File(ORDERS_FOLDER);
        File[] files = folder.listFiles();
        
        for (File file : files) {

            try {
                scanner = new Scanner(new BufferedReader(new FileReader(file)));
            } catch (FileNotFoundException e) {
                throw new FlooringPersistenceException("Could not load item data into memory.", e);
            }
            
            
            String currentLine;

            String[] currentTokens;

            String fileName = file.getName();
            String[] splitDate1 = fileName.split("_");
            String[] splitDate2 = splitDate1[1].split("\\.");
            LocalDate orderDate = LocalDate.parse(splitDate2[0], DateTimeFormatter.ofPattern("MMddyyyy"));
            this.dates.add(orderDate);

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();

                currentTokens = currentLine.split(DELIMITER);

                Order order = new Order(Integer.parseInt(currentTokens[0]));
                order.setCustomerName(currentTokens[1]);
                order.setState(currentTokens[2]);
                order.setStateTax(new BigDecimal(currentTokens[3]));
                order.setProductType(currentTokens[4]);
                order.setArea(new BigDecimal(currentTokens[5]));
                order.setCostPerSqFoot(new BigDecimal(currentTokens[6]));
                order.setLaborCostPerSqFoot(new BigDecimal(currentTokens[7]));
                order.setMaterialCost(new BigDecimal(currentTokens[8]));
                order.setTotalLaborCost(new BigDecimal(currentTokens[9]));
                order.setTotalTax(new BigDecimal(currentTokens[10]));
                order.setTotalCost(new BigDecimal(currentTokens[11]));
                order.setDate(orderDate);
                
                if (Integer.parseInt(currentTokens[0]) > orderId) {
                    orderId = Integer.parseInt(currentTokens[0]);
                }
                orders.put(order.getOrderIdNum(), order);
            }
            scanner.close();
        }
        return orderId;
    }

    @Override
    public Order addOrder(Order order) {
        Order newOrder = orders.put(order.getOrderIdNum(), order);
        return newOrder;

    }

    @Override
    public Order removeOrder(int orderIdNum) {

        Order removedOrder = orders.remove(orderIdNum);
        
        return removedOrder;
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        ArrayList<Order> orderList = new ArrayList<>();
        for (Order order : orders.values()) {
            orderList.add(order);
        }
        
        return orderList;
    }

    @Override
    public Order getOrder(int orderIdNum, LocalDate date) {
        return orders.get(orderIdNum);
    }

    @Override
    public Order updateOrder(int orderIdNum, Order order) {
        Order newOrder = orders.replace(orderIdNum, order);
        return newOrder;
    }

    @Override
    public void save() throws FlooringPersistenceException {
        
        PrintWriter out;
        File dir = new File(ORDERS_FOLDER);
        File[] file = dir.listFiles();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        
        Set<String> orderDates = new HashSet<>();
        
        for (LocalDate date : dates) {
            orderDates.add(date.format(formatter));
        }
        
        for (Order order : orders.values()) {
            orderDates.add(order.getDate().format(formatter));
        }
        
        
        for (String date : orderDates) {
            String path = "Orders/Orders_" + date + ".txt";
            try {
                out = new PrintWriter(new FileWriter(path));
            } catch (IOException e) {
                throw new FlooringPersistenceException("Could not save order data.");
            }
            List<Order> orders = this.getAllOrders();
            for (Order order : orders) {
                if (order.getDate().format(formatter).equals(date)) {
                    out.println(order.getOrderIdNum() + DELIMITER 
                            + order.getCustomerName() + DELIMITER 
                            + order.getState() + DELIMITER 
                            + order.getStateTax() + DELIMITER 
                            + order.getProductType() + DELIMITER 
                            + order.getArea() + DELIMITER 
                            + order.getCostPerSqFoot() + DELIMITER 
                            + order.getLaborCostPerSqFoot() + DELIMITER 
                            + order.getMaterialCost() + DELIMITER 
                            + order.getTotalLaborCost() + DELIMITER 
                            + order.getTotalTax() + DELIMITER 
                            + order.getTotalCost());
                    
                    out.flush();
                }
            }
            out.close();
            if (new File(path).length() == 0) {
                new File(path).delete();
            }
        }

    }
}
