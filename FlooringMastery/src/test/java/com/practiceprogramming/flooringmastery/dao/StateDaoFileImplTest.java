/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.State;
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
public class StateDaoFileImplTest {
    
    private StateDao dao;
    
    public StateDaoFileImplTest() {
        dao = new StateDaoFileImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<State> stateList = dao.getAllStates();
        for (State state : stateList) {
            dao.removeState(state);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllStates method, of class StateDaoFileImpl.
     */
    @Test
    public void testGetAllStates() {
        
        State state1 = new State();
        state1.setStateName("MA");
        state1.setTaxRate(new BigDecimal(9));
        
        dao.addState(state1);
        
        State state2 = new State();
        state2.setStateName("AK");
        state2.setTaxRate(new BigDecimal(12));
        
        dao.addState(state2);
        
        assertEquals(2, dao.getAllStates().size());
        
    }

    /**
     * Test of getState method, of class StateDaoFileImpl.
     */
    @Test
    public void testGetState() {
        State state = new State();
        state.setStateName("MA");
        state.setTaxRate(new BigDecimal(9));
        
        dao.addState(state);
        State newState = dao.getState("MA");
        assertEquals(state, newState);
    }

    /**
     * Test of addState method, of class StateDaoFileImpl.
     */
    @Test
    public void testAddState() {
        State state = new State();
        state.setStateName("MA");
        state.setTaxRate(new BigDecimal(9));
        
        dao.addState(state);
        State newState = dao.getState("MA");
        assertEquals(state, newState);
        
    }

    /**
     * Test of removeState method, of class StateDaoFileImpl.
     */
    @Test
    public void testRemoveState() {
        State state1 = new State();
        state1.setStateName("MA");
        state1.setTaxRate(new BigDecimal(9));
        
        dao.addState(state1);
        
        State state2 = new State();
        state2.setStateName("AK");
        state2.setTaxRate(new BigDecimal(12));
        
        dao.addState(state2);
        
        dao.removeState(state2);
        assertEquals(1, dao.getAllStates().size());
        assertNull(dao.getState("AK"));
    }

    /**
     * Test of load method, of class StateDaoFileImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoad() throws Exception {
        dao.load();
        List<State> stateList = dao.getAllStates();
    }
    
}
