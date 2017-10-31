package com.practiceprogramming.flooringmastery.dao;

import com.practiceprogramming.flooringmastery.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author owner
 */
public class StateDaoFileImpl implements StateDao {

    private Map<String, State> stateTaxes = new HashMap<>();

    public static final String DATA_FOLDER = "./Data/taxes.txt";
    public static final String DELIMITER = ",";

    @Override
    public List<State> getAllStates() {
        return new ArrayList<>(stateTaxes.values());
    }

    @Override
    public State getState(String state) {
        return stateTaxes.get(state);
    }

    @Override
    public State addState(State state) {
        State newState = stateTaxes.put(state.getStateName(), state);
        return newState;
    }

    @Override
    public State removeState(State state) {
        State removedState = stateTaxes.remove(state.getStateName());
        return removedState;
    }

    @Override
    public void load() throws FlooringPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DATA_FOLDER)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("Could not load item data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            State state = new State();
            state.setStateName(currentTokens[0]);
            state.setTaxRate(new BigDecimal(currentTokens[1]));
            stateTaxes.put(state.getStateName(), state);

        }
        scanner.close();
    }
}
