/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine.advice;

import com.practiceprogramming.vendingmachine.dao.VendingMachineAuditDao;
import com.practiceprogramming.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author owner
 */
public class LoggingAdvice {
    
    private VendingMachineAuditDao auditDao;
    
    //Constructor injection
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp, Exception e) {
        //ask jp to get the arguments
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        //cycle through arguments for auditEntry
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        auditEntry += " | " + e.getClass().getName();
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException j) {
            //print out to error stream
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
