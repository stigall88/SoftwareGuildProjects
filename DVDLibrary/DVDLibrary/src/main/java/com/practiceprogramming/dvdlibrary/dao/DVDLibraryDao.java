/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.dvdlibrary.dao;

import com.practiceprogramming.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author owner
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String dvdId, DVD dvd) throws DVDLibraryDaoException;
    
    List<DVD> listAllDVD() throws DVDLibraryDaoException;
    
    DVD removeDVD(String dvdID) throws DVDLibraryDaoException;
    
    DVD updateDVD(String dvdID, DVD dvd) throws DVDLibraryDaoException;
    
    DVD getDVD(String dvdID) throws DVDLibraryDaoException;
    
}
