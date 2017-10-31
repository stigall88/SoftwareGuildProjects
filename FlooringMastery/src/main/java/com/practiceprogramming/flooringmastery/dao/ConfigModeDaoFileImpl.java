/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class ConfigModeDaoFileImpl implements ConfigModeDao {
    
    public static final String DATA_FOLDER = "./Data/config.txt";

    @Override
    public boolean configMode() throws FlooringPersistenceException {
        
        boolean isConfigMode = true;
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DATA_FOLDER)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load order data into memory.", e);
        }
        String currentLine;
        currentLine = scanner.nextLine();
        isConfigMode = !currentLine.equals("mode = Production");
        scanner.close();
        return isConfigMode;
        
    }
    
}
