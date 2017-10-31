/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author owner
 */
public class OrdersDaoFileImplTest {
    
    private OrdersDao dao;
    
    public OrdersDaoFileImplTest() {
        dao = new OrdersDaoFileImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FlooringPersistenceException {
        int orderIdNum = 0;
        List<Order> orderList = dao.getAllOrders();
        for (Order order : orderList) {
            dao.removeOrder(orderIdNum);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testAddOrder() {
        
        Order order = new Order();
        order.setOrderIdNum(400);
        order.setDate(LocalDate.now());
        order.setCustomerName("McNaulty");
        order.setState("KY");
        order.setStateTax(new BigDecimal(6.0));
        order.setProductType("Nonus");
        order.setMaterialCost(new BigDecimal(20));
        order.setLaborCostPerSqFoot(new BigDecimal(8.50));
        
        dao.addOrder(order);
        
        Order newOrder = dao.getOrder(400, LocalDate.now());
        assertEquals(order, newOrder);
        
        
    }

    /**
     * Test of removeOrder method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        
        Order order1 = new Order();
        order1.setOrderIdNum(900);
        order1.setDate(LocalDate.now());
        order1.setCustomerName("McNaulty");
        order1.setState("KY");
        order1.setStateTax(new BigDecimal(6.0));
        order1.setProductType("Nonus");
        order1.setMaterialCost(new BigDecimal(20));
        order1.setLaborCostPerSqFoot(new BigDecimal(8.50));
        
        dao.addOrder(order1);
        
        Order order2 = new Order();
        order1.setOrderIdNum(901);
        order2.setDate(LocalDate.now());
        order2.setCustomerName("Justin");
        order2.setState("KY");
        order2.setStateTax(new BigDecimal(6.0));
        order2.setProductType("Carpet");
        order2.setMaterialCost(new BigDecimal(9));
        order2.setLaborCostPerSqFoot(new BigDecimal(4));
        
        dao.addOrder(order2);
        
        dao.removeOrder(901);
        assertEquals(2, dao.getAllOrders().size());
        assertNull(dao.getOrder(901, LocalDate.now()));
        
    }

    /**
     * Test of getAllOrders method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        
        Order order1 = new Order();
        order1.setOrderIdNum(900);
        order1.setDate(LocalDate.now());
        order1.setCustomerName("McNaulty");
        order1.setState("KY");
        order1.setStateTax(new BigDecimal(6.0));
        order1.setProductType("Nonus");
        order1.setMaterialCost(new BigDecimal(20));
        order1.setLaborCostPerSqFoot(new BigDecimal(8.50));
        
        dao.addOrder(order1);
        
        Order order2 = new Order();
        order1.setOrderIdNum(901);
        order2.setDate(LocalDate.now());
        order2.setCustomerName("Justin");
        order2.setState("KY");
        order2.setStateTax(new BigDecimal(6.0));
        order2.setProductType("Carpet");
        order2.setMaterialCost(new BigDecimal(9));
        order2.setLaborCostPerSqFoot(new BigDecimal(4));
        
        dao.addOrder(order2);
        
        assertEquals(2, dao.getAllOrders().size());
        
    }

    /**
     * Test of getOrder method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testGetOrder() {
    }

    /**
     * Test of updateOrder method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testUpdateOrder() {
    }

    /**
     * Test of write method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testWrite() throws Exception {
    }

    /**
     * Test of load method, of class OrdersDaoFileImpl.
     */
    @Test
    public void testLoad() throws Exception {
        dao.load();
        List<Order> orders = dao.getAllOrders();
    }
    
}
