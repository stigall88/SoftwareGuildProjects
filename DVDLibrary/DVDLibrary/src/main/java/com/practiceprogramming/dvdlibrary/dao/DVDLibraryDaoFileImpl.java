/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.dvdlibrary.dao;

import com.practiceprogramming.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String DVD_FILE = "dvdlibrary.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    /**
	 * Writes all DVDs in the collection out to a DVDLIBRARY_FILE.  
	 * 
	 * @throws DVDLibraryDaoException if an error occurs writing to the file
	 */
    
    private void writeDVDLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {

            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }
        
        // Write out the DVD objects to the library file.
        List<DVD> dvds = this.listAllDVD();
        for (DVD newDVD : dvds) {
            //write dvd object to the file
            out.println(newDVD.getDvdID() + DELIMITER +
                    newDVD.getTitle() + DELIMITER +
                    newDVD.getReleaseDate() + DELIMITER + 
                    newDVD.getDirector() + DELIMITER + 
                    newDVD.getMpaaRating() + DELIMITER + 
                    newDVD.getStudio() + DELIMITER + 
                    newDVD.getUserRating());
            // force PrintWriter to write line to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

    private void loadDVDLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load DVD data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;
        // Go through DVDLIBRARY_FILE line by line, decoding each line into a 
        // DVD object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new DVD object and put it into the map of dvds

            // which is currentTokens[0] as the map key for our DVD object.
            // We also have to pass the dvd id into the DVD constructor
            DVD newDVD = new DVD(currentTokens[0]);
            // Set the remaining vlaues on newDVD manually
            newDVD.setTitle(currentTokens[1]);
            newDVD.setReleaseDate(currentTokens[2]);
            newDVD.setMpaaRating(currentTokens[3]);
            newDVD.setDirector(currentTokens[4]);
            newDVD.setStudio(currentTokens[5]);
            newDVD.setUserRating(currentTokens[6]);

            // Put newDVD into the map using getDvdId as the key
            dvds.put(newDVD.getDvdID(), newDVD);
        }
        // close scanner
        scanner.close();
    }

    @Override
    public DVD addDVD(String dvdId, DVD dvd) throws DVDLibraryDaoException {
        loadDVDLibrary();
        //adds dvd to the map by its ID
        DVD newDVD = dvds.put(dvd.getDvdID(), dvd);
        writeDVDLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> listAllDVD() throws DVDLibraryDaoException {
        loadDVDLibrary();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD removeDVD(String dvdID) throws DVDLibraryDaoException {
        loadDVDLibrary();
        DVD removedDVD = dvds.remove(dvdID);
        writeDVDLibrary();
        return removedDVD;
    }

    @Override
    public DVD updateDVD(String dvdID, DVD dvd) throws DVDLibraryDaoException {
        loadDVDLibrary();
        DVD newDVD = dvds.replace(dvdID, dvd);
        writeDVDLibrary();
        return newDVD;
    }

    @Override
    public DVD getDVD(String dvdID) throws DVDLibraryDaoException {
        loadDVDLibrary();
        return dvds.get(dvdID);
    }

}
