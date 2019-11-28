package com.company;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3.");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
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
    }
}

 // Constructor removed, not needed?

//Play against human / number of players
//Play against computer / AI
//Quit game
// ---
// Copy/Paste below into Main to see if it works.
// Menu menu = new Menu();
//  menu.Choices();
// ---