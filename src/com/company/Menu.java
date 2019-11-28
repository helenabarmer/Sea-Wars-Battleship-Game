package com.company;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    //switch case menu
    public void Menu(){
        int switchChoice = 0;
        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3.");
        int userChoice = scanner.nextInt();
        switch (switchChoice){
            case 1:
                System.out.println("Player VS Player (PVP)");
                break;

            case 2:
                System.out.println("Player VS Computer (AI)");
                break;

            case 3:
                System.out.println("Quit Sea Wars");
                break;
        }
        System.out.println(switchChoice);
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