package com.company;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    // Get "battle" to start the battle through the BattleShipProgram
    // BattleShipProgram battle = new BattleShipProgram();

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3. Press <ENTER>");
        System.out.println("1. Player VS Player (PvP)");
        System.out.println("2. Player VS Computer (PvE)");
        System.out.println("3. Quit Sea Wars");
        int userChoice = scanner.nextInt();
        String playerName = scanner.nextLine();

        switch (userChoice) {
            case 1:
                System.out.println("Player VS Player (PvP)");
                System.out.println("Player 1, please place your ships (6) as shown below");
                Human player1 = new Human(playerName);
                System.out.println("Player 2, please place your ships (6) as shown below");
                Human player2 = new Human(playerName);
                //do battle {

                // }
                // while {
                // }
                break;

            case 2:
                System.out.println("Player VS Computer (PvE)");
                Human human = new Human(playerName);
                Map humanMap = new Map();

                // Name of Computer will include automatically via Computer-Class
                Computer computer = new Computer();
                Map computerMap = new Map();
                break;
                //do battle {

                // }
                // while {
                // }
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
// Copy/Paste below into Main to run method.
// Menu menu = new Menu();
//  menu.Choices();
// ---