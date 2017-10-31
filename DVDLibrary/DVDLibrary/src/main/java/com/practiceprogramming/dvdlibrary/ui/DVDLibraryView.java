/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practiceprogramming.dvdlibrary.ui;

import com.practiceprogramming.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author owner
 */
public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("1.) Add a DVD");
        io.print("2.) Remove a DVD");
        io.print("3.) Edit a DVD");
        io.print("4.) List all DVD movies");
        io.print("5.) View a DVD");
        io.print("6.) Search for a DVD");
        io.print("7.) Exit");

        return io.readInt("Please make selection above", 1, 7);
    }

    //++++++++++++++++++++++++++++++++++++ ADD DVD +++++++++++++++++++++++++++++++++++
    public DVD getNewDVDInfo() {
        String dvdID = io.readString("Please enter DVD ID");
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter the release date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String director = io.readString("Please the Director's name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter your rating for this DVD");
        DVD newDVD = new DVD(dvdID);
        newDVD.setTitle(title);
        newDVD.setReleaseDate("Release Date " + releaseDate);
        newDVD.setMpaaRating("MPAA Rating: " + mpaaRating);
        newDVD.setDirector("Director: " + director);
        newDVD.setStudio("Studio: " + studio);
        newDVD.setUserRating("Your rating: " + userRating);
        return newDVD;

    }

    public void displayAddDVDBanner() {
        io.print("========= ADD DVD =========");
    }

    public void displayAddDVDSuccessBanner() {
        io.print("Your DVD has been successfully added. Please hit enter to continue!");
    }

    //++++++++++++++++++++++++++++++++++++ REMOVE DVD +++++++++++++++++++++++++++++++++++
    public void displayRemoveDVDBanner() {
        io.print("========= REMOVE DVD =========");
    }

    public void displayRemoveDVDSuccessBanner() {
        io.print("The DVD has been successfully removed. Please hit enter to continue!");
    }

    //++++++++++++++++++++++++++++++++++++ EDIT DVD ++++++++++++++++++++++++++++++++++++
    public void displayEditDVDBanner() {
        io.print("========= EDIT DVD =========");
    }

    public DVD updatedDVD(String dvdID) {
        String dvdTitle = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter the release date");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        String director = io.readString("Please enter the Director's name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter your rating for this DVD");
        DVD newDVD = new DVD(dvdID);
        newDVD.setTitle(dvdTitle);
        newDVD.setReleaseDate("Release Date " + releaseDate);
        newDVD.setMpaaRating("MPAA Rating: " + mpaaRating);
        newDVD.setDirector("Director: " + director);
        newDVD.setStudio("Studio: " + studio);
        newDVD.setUserRating("Your rating: " + userRating);
        return newDVD;
    }

    public void displayEditDVDSuccessBanner() {
        io.print("All changes have been saved. Please hit to continue!");
    }

    //++++++++++++++++++++++++++++++++++++ LIST DVD ++++++++++++++++++++++++++++++++++++
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD newDVD : dvdList) {
            io.print(newDVD.getDvdID() + " "
                    + newDVD.getTitle() + " "
                    + newDVD.getReleaseDate() + " "
                    + newDVD.getMpaaRating() + " "
                    + newDVD.getDirector() + " "
                    + newDVD.getStudio() + " "
                    + newDVD.getUserRating());
        }
        io.readString("Please hit enter to continue");
    }

    public void displayListDVDBanner() {
        io.print("========= LIST ALL DVDs =========");
    }

    //++++++++++++++++++++++++++++++++++++ VIEW DVD ++++++++++++++++++++++++++++++++++++
    public void displayViewDVDBanner() {
        io.print("========= VIEW DVD =========");
    }

    public String getDVDIdChoice() {
        return io.readString("Please enter the ID of the DVD you would like to view");
    }

    public void displayDVDChoice(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getDvdID());
            io.print(dvd.getTitle());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD exists");
        }
        io.readString("Please hit enter to continue");
    }

    //++++++++++++++++++++++++++++++++++++ SEARCH DVD ++++++++++++++++++++++++++++++++++++
    public void displaySearchForDVDBanner() {
        io.print("========= SEARCH FOR DVD =========");
    }

    public String getDVDTitle() {
        return io.readString("Please enter the title of the DVD");
    }

    public void displaySearchedDVD (List<DVD> currentList, String titleForSearch) {
        

        List<String> searchList = new ArrayList<>();

        for (DVD newDVD : currentList) {
            String dvdTitle = titleForSearch.toLowerCase();
            CharSequence checkFor = titleForSearch;
            String newTitle = newDVD.getTitle();
            if (newTitle.toLowerCase().contains(checkFor)) {
                searchList.add(newTitle);
            }

        }

        //Iterates over the DVDs in the list Iterator
        Iterator<String> iterate = searchList.iterator();

        //isEmpty is a boolean that will return true if the 
        //list contains no elements
        if (!searchList.isEmpty()) {
            io.print("These are the results of your search: ");

            //the iteration is going to continue to loop to the next line if there is one
            while (iterate.hasNext()) {
                String current = iterate.next();
                io.print(current);

            }
        } else {
            io.print("No matches found!");
        }
        io.print("Please hit enter to continue");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnkownCommandBanner() {
        io.print("UNKNOWN COMMAND");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
