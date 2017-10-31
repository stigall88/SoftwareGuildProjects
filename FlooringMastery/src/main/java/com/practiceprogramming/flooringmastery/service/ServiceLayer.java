/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.service;

import com.practiceprogramming.flooringmastery.dao.FlooringPersistenceException;
import com.practiceprogramming.flooringmastery.dto.Order;
import com.practiceprogramming.flooringmastery.dto.Product;
import com.practiceprogramming.flooringmastery.dto.State;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public interface ServiceLayer {
    
    Order addOrder(int orderIdNum, Order order);
    
    Order removeOrder(int orderIdNum);
    
    Order completeOrder(Order order);
    
    Order getOrder(int orderIdNum, LocalDate date) throws InvalidOrderDateException;
    
    Order updateOrder(Order order);
    
    List<Order> getAllOrders() throws FlooringPersistenceException;
    
    List<Order> getOrdersByDate(LocalDate date) throws InvalidOrderDateException, FlooringPersistenceException;
    
    List<Product> getAllProducts();
    
    List<State> getAllStates();
    
    public int getNextIdNum() throws FlooringPersistenceException;
    
    public void save() throws FlooringPersistenceException;
    
    public void load() throws FlooringPersistenceException;
    
    boolean isConfigMode() throws FlooringPersistenceException;
    
}
