/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.vendingmachine;

import com.practiceprogramming.vendingmachine.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author owner
 */
public class App {
    
    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
//        Controller controller = new Controller(myView, myService);
//        controller.run();

          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          Controller controller = ctx.getBean("controller", Controller.class);
          controller.run();
    }
    
}
