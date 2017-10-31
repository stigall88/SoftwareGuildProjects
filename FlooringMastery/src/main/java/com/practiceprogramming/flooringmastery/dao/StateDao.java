/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;


import com.practiceprogramming.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author owner
 */
public interface StateDao {
    
    State addState(State state);
    
    List<State> getAllStates();
    
    State removeState(State state);
    
    State getState(String state);
    
    public void load() throws FlooringPersistenceException;
}
