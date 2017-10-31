/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.service;

/**
 *
 * @author owner
 */
public class FlooringUserInputException extends Exception {
    
    public FlooringUserInputException(String message) {
        super(message);
    }
    
    public FlooringUserInputException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
