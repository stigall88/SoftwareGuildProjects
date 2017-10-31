/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.dvdlibrary.controller;

import com.practiceprogramming.dvdlibrary.dao.DVDLibraryDao;
import com.practiceprogramming.dvdlibrary.dao.DVDLibraryDaoException;
import com.practiceprogramming.dvdlibrary.dto.DVD;
import com.practiceprogramming.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author owner
 */
public class DVDLibraryController {
    
    private DVDLibraryView view;
    private DVDLibraryDao dao;
       
    //Constructor used for dependency injection
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case 1:
                    addDVD();
                    break;
                case 2: 
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listAllDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
                case 6:
                    searchDVD();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    public void addDVD() throws DVDLibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDvdID(), newDVD);
        view.displayAddDVDSuccessBanner();
    }
    
    public void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdID = view.getDVDIdChoice();
        dao.removeDVD(dvdID);
        view.displayRemoveDVDSuccessBanner();
    }
    
    public void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String dvdID = view.getDVDIdChoice();
        DVD dvd = view.updatedDVD(dvdID);
        dao.updateDVD(dvdID, dvd);
        view.displayEditDVDSuccessBanner();
        
    }
    
    public void listAllDVDs() throws DVDLibraryDaoException {
        view.displayListDVDBanner();
        List<DVD> dvdList = dao.listAllDVD();
        view.displayDVDList(dvdList);
    }
    
    public void viewDVD() throws DVDLibraryDaoException {
        view.displayViewDVDBanner();
        String dvdID = view.getDVDIdChoice();
        DVD dvd = dao.getDVD(dvdID);
        view.displayDVDChoice(dvd);
    }
    
    public void searchDVD() throws DVDLibraryDaoException {
        view.displaySearchForDVDBanner();
        String dvdTitle = view.getDVDTitle();
        List<DVD> currentList = dao.listAllDVD();
        view.displaySearchedDVD(currentList, dvdTitle);
    }
    
    private void unknownCommand() {
        view.displayUnkownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }

}
