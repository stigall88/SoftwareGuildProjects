/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.service;

import com.practiceprogramming.flooringmastery.dao.ConfigModeDao;
import com.practiceprogramming.flooringmastery.dao.FlooringPersistenceException;
import com.practiceprogramming.flooringmastery.dao.OrdersDao;
import com.practiceprogramming.flooringmastery.dao.ProductDao;
import com.practiceprogramming.flooringmastery.dao.StateDao;
import com.practiceprogramming.flooringmastery.dto.Order;
import com.practiceprogramming.flooringmastery.dto.Product;
import com.practiceprogramming.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public class ServiceLayerImpl implements ServiceLayer {

    private ProductDao productDao;
    private StateDao stateDao;
    private OrdersDao orderDao;
    private ConfigModeDao configModeDao;
    private int orderIdNums;

    public ServiceLayerImpl(ProductDao productDao, StateDao stateDao, OrdersDao orderDao, ConfigModeDao configDao) {

        this.productDao = productDao;
        this.stateDao = stateDao;
        this.orderDao = orderDao;
        this.configModeDao = configDao;

    }

    @Override
    public Order addOrder(int orderIdNum, Order order) {
        return orderDao.addOrder(order);

    }

    @Override
    public Order removeOrder(int orderIdNum) {
        return orderDao.removeOrder(orderIdNum);
    }

    @Override
    public Order completeOrder(Order order) {

        BigDecimal materialCost;
        BigDecimal laborCost;
        BigDecimal beforeTax;
        BigDecimal totalTax;
        BigDecimal total;

        materialCost = order.getCostPerSqFoot().multiply(order.getArea().setScale(2, RoundingMode.HALF_UP));
        laborCost = order.getLaborCostPerSqFoot().multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP);
        beforeTax = materialCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);
        totalTax = order.getStateTax().divide(new BigDecimal(100)).multiply(beforeTax).setScale(2, RoundingMode.HALF_UP);
        total = beforeTax.add(totalTax).setScale(2, RoundingMode.HALF_UP);

        order.setMaterialCost(materialCost);
        order.setTotalLaborCost(laborCost);
        order.setTotalTax(totalTax);
        order.setTotalCost(total);

        return order;
    }

    @Override
    public Order getOrder(int orderIdNum, LocalDate date) throws InvalidOrderDateException {

        Order newOrder = orderDao.getOrder(orderIdNum, date);
        if (newOrder == null) {
            throw new InvalidOrderDateException("No order found for that date");
        }
        return newOrder;
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) throws InvalidOrderDateException, FlooringPersistenceException {
        List<Order> ordersByDate = new ArrayList<>();
        for (Order orders : orderDao.getAllOrders()) {
            if (orders.getDate().equals(date)) {
                ordersByDate.add(orders);
            }
        }
        return ordersByDate;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<State> getAllStates() {
        return stateDao.getAllStates();
    }

    @Override
    public void save() throws FlooringPersistenceException {
        orderDao.save();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.updateOrder(+1, order);
    }

    @Override
    public int getNextIdNum() throws FlooringPersistenceException {
        int orderIdNum = 0;
        List<Order> allOrders = getAllOrders();
        for (Order order : allOrders) {
            if (order.getOrderIdNum() >= orderIdNum) {
                orderIdNum = order.getOrderIdNum() + 1;
            }
        }
        return orderIdNum;
    }

    @Override
    public void load() throws FlooringPersistenceException {
        orderDao.load();
        stateDao.load();
        productDao.loadProduct();
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        return orderDao.getAllOrders();

    }

    @Override
    public boolean isConfigMode() throws FlooringPersistenceException {
        return configModeDao.configMode();
    }
}
