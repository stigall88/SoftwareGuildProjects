/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author owner
 */
public class StateDaoStubImpl implements StateDao {
    
    private State onlyState = new State();
    private List<State> stateList = new ArrayList<>();
    
    public StateDaoStubImpl() {
        onlyState.setStateName("KY");
        onlyState.setTaxRate(new BigDecimal(6));
        
        stateList.add(onlyState);
    }

    @Override
    public State addState(State state) {
        if (state.equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public List<State> getAllStates() {
        return stateList;
    }

    @Override
    public State removeState(State state) {
        if (state.equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public State getState(String state) {
        if (state.equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public void load() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
