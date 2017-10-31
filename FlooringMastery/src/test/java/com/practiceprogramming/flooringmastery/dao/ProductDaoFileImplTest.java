/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Product;
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
public class ProductDaoFileImplTest {

    private ProductDao dao;

    public ProductDaoFileImplTest() {
        dao = new ProductDaoFileImpl();
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String name = "";
        List<Product> productList = dao.getAllProducts();
        for (Product product : productList) {
            dao.removeProduct(name, product);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class ProductDaoFileImpl.
     */
    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setProductName("Marble");
        product.setCostPerSqFt(new BigDecimal(15));
        product.setLaborCostPerSqFt(new BigDecimal(11));

        dao.addProduct("Marble", product);

        Product newProduct = dao.getProduct("Marble");
        assertEquals(product, newProduct);
    }

    /**
     * Test of getAllProducts method, of class ProductDaoFileImpl.
     */
    @Test
    public void testGetAllProducts() {

        Product product1 = new Product();
        product1.setProductName("Marble");
        product1.setCostPerSqFt(new BigDecimal(15));
        product1.setLaborCostPerSqFt(new BigDecimal(11));

        dao.addProduct("Marble", product1);

        Product product2 = new Product();
        product2.setProductName("Carpet");
        product2.setCostPerSqFt(new BigDecimal(9));
        product2.setLaborCostPerSqFt(new BigDecimal(4));

        dao.addProduct("Carpet", product2);
        
        assertEquals(2, dao.getAllProducts().size());

    }

    /**
     * Test of getProduct method, of class ProductDaoFileImpl.
     */
    @Test
    public void testGetProduct() {

        Product product = new Product();
        product.setProductName("Marble");
        product.setCostPerSqFt(new BigDecimal(15));
        product.setLaborCostPerSqFt(new BigDecimal(11));

        dao.addProduct("Marble", product);

        Product newProduct = dao.getProduct("Marble");
        assertEquals(product, newProduct);

    }

    /**
     * Test of removeProduct method, of class ProductDaoFileImpl.
     */
    @Test
    public void testRemoveProduct() {

        Product product1 = new Product();
        product1.setProductName("Marble");
        product1.setCostPerSqFt(new BigDecimal(15));
        product1.setLaborCostPerSqFt(new BigDecimal(11));

        dao.addProduct("Marble", product1);

        Product product2 = new Product();
        product2.setProductName("Carpet");
        product2.setCostPerSqFt(new BigDecimal(9));
        product2.setLaborCostPerSqFt(new BigDecimal(4));

        dao.addProduct("Carpet", product2);

        dao.removeProduct("Marble", product1);
        assertEquals(1, dao.getAllProducts().size());
        assertNull(dao.getProduct("Marble"));

    }

    /**
     * Test of loadProduct method, of class ProductDaoFileImpl.
     */
    @Test
    public void testLoadProduct() throws Exception {
    }

}
