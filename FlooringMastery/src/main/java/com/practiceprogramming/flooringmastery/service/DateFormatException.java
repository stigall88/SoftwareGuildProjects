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
public class DateFormatException extends Exception {
    
    public DateFormatException(String message) {
        super(message);
    }
    
    public DateFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
