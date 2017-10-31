/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.service;

import com.practiceprogramming.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author owner
 */
public class ServiceLayerImplTest {

    private ServiceLayer service;

    public ServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        service = ctx.getBean("serviceLayer", ServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        int orderIdNum = 0;
        List<Order> orderList = service.getAllOrders();
        for (Order order : orderList) {
            service.removeOrder(orderIdNum);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class ServiceLayerImpl.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setOrderIdNum(400);
        order.setDate(LocalDate.now());
        order.setCustomerName("McNaulty");
        order.setState("KY");
        order.setStateTax(new BigDecimal(6.0));
        order.setProductType("Nonus");
        order.setMaterialCost(new BigDecimal(20));
        order.setLaborCostPerSqFoot(new BigDecimal(8.50));
        
        service.addOrder(400, order);
        
        Order newOrder = service.getOrder(400, LocalDate.now());
        assertEquals(order, newOrder);
    }

    /**
     * Test of removeOrder method, of class ServiceLayerImpl.
     */
    @Test
    public void testRemoveOrder() {
    }

    /**
     * Test of completeOrder method, of class ServiceLayerImpl.
     */
    @Test
    public void testCompleteOrder() throws Exception {
//        int orderIdNum = 40;
//        LocalDate date = ;
//        Order order = service.getOrder(orderIdNum, date);
//        order = service.completeOrder(order);
//        BigDecimal matCost = order.getMaterialCost();
//        BigDecimal labCost = order.getLaborCostPerSqFoot();
//        BigDecimal totalCost = order.getTotalCost();
//        BigDecimal totalTax = order.getTotalTax();
//
//        assertEquals(matCost, new BigDecimal(4469).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(labCost, new BigDecimal(4.14).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(totalTax, new BigDecimal(246).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(totalCost, new BigDecimal(5166).setScale(2, RoundingMode.HALF_UP));

    }

    /**
     * Test of getOrder method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        
//        Order order = new Order();
//        order.setOrderIdNum(400);
//        order.setDate(LocalDate.now());
//        order.setCustomerName("McNaulty");
//        order.setState("KY");
//        order.setStateTax(new BigDecimal(6.0));
//        order.setProductType("Nonus");
//        order.setMaterialCost(new BigDecimal(20));
//        order.setLaborCostPerSqFoot(new BigDecimal(8.50));
//        
//        service.addOrder(400, order);
//        
//        Order newOrder = service.getOrder(400, LocalDate.now());
//        assertEquals(order, newOrder);
        
    }

    /**
     * Test of getOrdersByDate method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        
        
        
    }

    /**
     * Test of getAllProducts method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAllProducts() {
    }

    /**
     * Test of getAllStates method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAllStates() {
    }

    /**
     * Test of save method, of class ServiceLayerImpl.
     */
    @Test
    public void testSave() throws Exception {
    }

    /**
     * Test of updateOrder method, of class ServiceLayerImpl.
     */
    @Test
    public void testUpdateOrder() {
    }

    /**
     * Test of getNextIdNum method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetNextIdNum() throws Exception {
    }

    /**
     * Test of load method, of class ServiceLayerImpl.
     */
    @Test
    public void testLoad() throws Exception {
    }

}
