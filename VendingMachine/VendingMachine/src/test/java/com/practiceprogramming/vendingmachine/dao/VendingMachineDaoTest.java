/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.dao;

import com.practiceprogramming.vendingmachine.dto.Item;
import java.math.BigDecimal;
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
public class VendingMachineDaoTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Item> itemList = dao.getAllItems();
        for (Item item : itemList) {
            dao.removeItem(item.getItemID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {

        Item item1 = new Item("001");
        item1.setItemName("Bulbasaur");
        item1.setItemCost(new BigDecimal(10.00));
        item1.setItemInventory(1);

        dao.addItem(item1.getItemID(), item1);

        Item item2 = new Item("003");
        item2.setItemName("Venusaur");
        item2.setItemCost(new BigDecimal(50.00));
        item2.setItemInventory(1);

        dao.addItem(item2.getItemID(), item2);

        Item item3 = new Item("004");
        item3.setItemName("Charmander");
        item3.setItemCost(new BigDecimal(10.00));
        item3.setItemInventory(1);

        dao.addItem(item3.getItemID(), item3);

        assertEquals(3, dao.getAllItems().size());
    }

    /**
     * Test of addItem method, of class VendingMachineDao.
     */
    @Test
    public void testAddGetItem() throws Exception {

        Item item = new Item("000");
        item.setItemName("PokeBalls");
        item.setItemCost(new BigDecimal(2.50));
        item.setItemInventory(1);

        dao.addItem(item.getItemID(), item);

        Item fromDao = dao.getItem(item.getItemID());

        assertEquals(item, fromDao);
    }

    /**
     * Test of updateInventory method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateInventory() throws Exception {
        
        Item item = new Item("000");
        item.setItemName("PokeBalls");
        item.setItemCost(new BigDecimal(2.50));
        item.setItemInventory(1);
        
        dao.updateInventory(item, 1);
        assertEquals(0, item.getItemInventory());
        
    }

    /**
     * Test of removeItem method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItem() throws Exception {

        Item item1 = new Item("001");
        item1.setItemName("Bulbasaur");
        item1.setItemCost(new BigDecimal(10.00));
        item1.setItemInventory(1);

        dao.addItem(item1.getItemID(), item1);

        Item item2 = new Item("003");
        item2.setItemName("Venusaur");
        item2.setItemCost(new BigDecimal(50.00));
        item2.setItemInventory(1);

        dao.addItem(item2.getItemID(), item2);

        Item item3 = new Item("004");
        item3.setItemName("Charmander");
        item3.setItemCost(new BigDecimal(10.00));
        item3.setItemInventory(1);

        dao.addItem(item3.getItemID(), item3);

        assertEquals(3, dao.getAllItems().size());
        
        dao.removeItem(item1.getItemID());
        assertEquals(2, dao.getAllItems().size());
        assertNull(dao.getItem(item1.getItemID()));
        
        dao.removeItem(item2.getItemID());
        assertEquals(1, dao.getAllItems().size());
        assertNull(dao.getItem(item2.getItemID()));

    }

}
