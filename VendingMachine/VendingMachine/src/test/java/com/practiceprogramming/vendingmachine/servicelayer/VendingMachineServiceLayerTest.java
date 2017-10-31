/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.servicelayer;

import com.practiceprogramming.vendingmachine.dto.Change;
import com.practiceprogramming.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author owner
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() {
//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
//
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);

          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of changeInserted method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testChangeInserted() throws Exception {

        BigDecimal userMoney = new BigDecimal(100);

        Item item = new Item("001");
        item.setItemName("Bulbasaur");
        item.setItemCost(new BigDecimal(10.00));
        item.setItemInventory(1);
        service.changeInserted(userMoney);

    }

    /**
     * Test of returnChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testReturnChange() throws Exception {

        BigDecimal userMoney = new BigDecimal(10);
        userMoney = service.changeInserted(new BigDecimal(10));
        Integer numOfPennies = userMoney.multiply(new BigDecimal(100)).intValue();
        Change change = new Change(numOfPennies);

        Change newChange = service.returnChange();

        assertEquals(change, newChange);
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testPurchaseItem() throws Exception {

        BigDecimal userMoney = service.changeInserted(new BigDecimal(10.00));
        Item item = new Item("001");
        item.setItemName("Bulbasaur");
        item.setItemCost(new BigDecimal(10.00));
        item.setItemInventory(1);

        assertEquals(item, service.purchaseItem(item));

    }

    /**
     * Test of changeBalance method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testChangeBalance() throws Exception {

        Item item = new Item("001");
        item.setItemName("Bulbasaur");
        item.setItemCost(new BigDecimal(10.00));
        item.setItemInventory(1);
        service.changeBalance();

    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {

        Item item = service.getItem("000");
        assertNotNull(item);

    }

    @Test
    public void testGetItemDoesntExist() throws Exception {

        Item item = new Item("999");
        item.setItemName("");
        item.setItemCost(new BigDecimal(1));
        item.setItemInventory(1);

        try {
            service.getItem("999");
            fail("expected VendingMachineIdNotValidException");
        } catch (VendingMachineIdNotValidException e) {
            return;
        }

    }

    @Test
    public void testItemOutOfStock() throws Exception {

        Item item = new Item("000");
        item.setItemName("PokeBalls");
        item.setItemCost(new BigDecimal(1));
        item.setItemInventory(0);

        try {
            service.purchaseItem(item);
        } catch (VendingMachineOutOfStockException e) {
            return;
        }

    }
    
    @Test
    public void testInsufficientFunds() throws Exception {
        
        BigDecimal userMoney = new BigDecimal(5);
        
        Item item = new Item("000");
        item.setItemName("PokeBalls");
        item.setItemCost(new BigDecimal(10));
        item.setItemInventory(1);
        
        try {
            service.purchaseItem(item);
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {

        assertEquals(1, service.getAllItems().size());

    }

}
