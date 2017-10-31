/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author owner
 */
public interface OrdersDao {
    
    Order addOrder(Order order);
    
    Order removeOrder(int orderIdNum);
    
    List<Order> getAllOrders() throws FlooringPersistenceException;
    
    Order getOrder(int orderIdNum, LocalDate date);
    
    Order updateOrder(int orderIdNum, Order order);
    
    int load() throws FlooringPersistenceException;
    
    void save() throws FlooringPersistenceException;
}
