/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Product;
import java.util.List;

/**
 *
 * @author owner
 */
public interface ProductDao {
    
    Product addProduct(String name, Product product);
    
    List<Product> getAllProducts();
    
    Product getProduct(String name);
    
    Product removeProduct(String name, Product product);
    
    public void loadProduct() throws FlooringPersistenceException;
}
