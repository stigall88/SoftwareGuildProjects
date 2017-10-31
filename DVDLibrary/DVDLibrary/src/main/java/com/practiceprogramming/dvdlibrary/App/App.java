/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.dvdlibrary.App;

import com.practiceprogramming.dvdlibrary.controller.DVDLibraryController;
import com.practiceprogramming.dvdlibrary.dao.DVDLibraryDao;
import com.practiceprogramming.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.practiceprogramming.dvdlibrary.ui.DVDLibraryView;
import com.practiceprogramming.dvdlibrary.ui.UserIO;
import com.practiceprogramming.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author owner
 */
public class App {
    
    public static void main(String[] args) {
        
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
        
    }
    
}
