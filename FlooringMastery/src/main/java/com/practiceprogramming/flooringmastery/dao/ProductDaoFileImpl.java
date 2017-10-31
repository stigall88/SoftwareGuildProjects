/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class ProductDaoFileImpl implements ProductDao {
    
    private Map<String, Product> products = new HashMap<>();
    
    public static final String DATA_FOLDER = "./Data/products.txt";
    public static final String DELIMITER = ",";

    @Override
    public Product addProduct(String name, Product product) {
        return products.put(product.getProductName(), product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProduct(String name) {
        return products.get(name);
    }

    @Override
    public Product removeProduct(String name, Product product) {
        return products.remove(product.getProductName());
    }

    @Override
    public void loadProduct() throws FlooringPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DATA_FOLDER)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("Could not load item data into memory.", e);
        }
        String currentLine;
        
        String[] currentTokens;
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);
            
            Product product = new Product();
            product.setProductName(currentTokens[0]);
            product.setCostPerSqFt(new BigDecimal(currentTokens[1]));
            product.setLaborCostPerSqFt(new BigDecimal(currentTokens[2]));
            products.put(product.getProductName(), product);
            
        }
        scanner.close();
    }
    
}
