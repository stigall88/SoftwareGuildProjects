/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public class OrderDaoStubImpl implements OrdersDao {
    
    private Order onlyOrder = new Order();
    private List<Order> orderList = new ArrayList<>();
    
    public OrderDaoStubImpl() {
        onlyOrder.setDate(LocalDate.now());
        onlyOrder.setCustomerName("Stigall");
        onlyOrder.setOrderIdNum(600);
        onlyOrder.setArea(new BigDecimal(50));
        onlyOrder.setCostPerSqFoot(new BigDecimal(9));
        onlyOrder.setLaborCostPerSqFoot(new BigDecimal(11));
        onlyOrder.setMaterialCost(new BigDecimal(534));
        onlyOrder.setProductType("Marble");
        onlyOrder.setState("KY");
        onlyOrder.setStateTax(new BigDecimal(6));
    }

    @Override
    public Order addOrder(Order order) {
        if (order.equals(onlyOrder.getOrderIdNum())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(int orderIdNum) {
        if (orderIdNum == onlyOrder.getOrderIdNum()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        return orderList;
    }

    @Override
    public Order getOrder(int orderIdNum, LocalDate date) {
        if (date.equals(onlyOrder.getDate())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order updateOrder(int orderIdNum, Order order) {
        if (orderIdNum == onlyOrder.getOrderIdNum()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public int load() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
