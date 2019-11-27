package com.company;

public class Menu {

    //switch case menu
    public static void Menu(){
        int caseNum = 0;
        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3.");
        switch (caseNum){
            case 1:
                System.out.println("This is CASE 1");
                break;

            case 2:
                System.out.println("This is CASE 2");
                break;

            case 3:
                System.out.println("This is CASE 3");
                break;
        }
    }

    // constructor
    public Menu() {
    }

}
//Play against human / number of players
//Play against computer / AI
//Quit game
// ---
// Copy/Paste below into Main to see if it works.
// Menu menu = new Menu();
//  menu.Menu();
// ---