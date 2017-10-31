/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public class ProductDaoStubImpl implements ProductDao {
    
    private Product onlyProduct = new Product();
    private List<Product> productList = new ArrayList<>();
    
    public ProductDaoStubImpl() {
        
        onlyProduct.setProductName("Wood");
        onlyProduct.setCostPerSqFt(new BigDecimal(5));
        onlyProduct.setLaborCostPerSqFt(new BigDecimal(10));
        
        productList.add(onlyProduct);
    }

    @Override
    public Product addProduct(String name, Product product) {
        if (name.equals(onlyProduct.getProductName())) {
            return onlyProduct;
        } else { 
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProduct(String name) {
        if (name.equals(onlyProduct.getProductName())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product removeProduct(String name, Product product) {
        if (name.equals(onlyProduct.getProductName())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public void loadProduct() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
