/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.flooringmastery;

import com.practiceprogramming.flooringmastery.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author owner
 */
public class App {
    
    public static void main(String[] args) {
        
//        UserIO myIO = new UserIOConsoleImpl();
//        View myView = new View(myIO);
//        OrdersDao orderDao = new OrdersDaoFileImpl();
//        ProductDao productDao = new ProductDaoFileImpl();
//        StateDao stateDao = new StateDaoFileImpl();
//        ServiceLayer service = new ServiceLayerImpl(productDao, stateDao, orderDao);
//        Controller controller = new Controller(myView, service);
//        controller.run();
       ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();
    }
    
}
