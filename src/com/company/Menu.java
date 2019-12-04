package com.company;

import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    public Scanner getScanner() {
        return input;
    }

    // Get "battle" to start the battle through the BattleShipProgram
    // BattleShipProgram battle = new BattleShipProgram();

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3. Press <ENTER>");
        System.out.println("1. Player VS Player (PvP)");
        System.out.println("2. Player VS Computer (PvE)");
        System.out.println("3. Quit Sea Wars");
        int userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                System.out.println("You have chosen 'Player VS Player' (PvP)");
                // Player One...
                System.out.println("Player 1, please type in your name");
                Human player1 = new Human(""); // player is the input from user.

                // Player Two...
                System.out.println("Player 2, please type in your name");
                Human player2 = new Human(""); // player is the input from user.
                // We use player1 and player2 later in the do-while-loop, where we toggle BATTLE.

                System.out.println(player1.getName() + " " + ", please place your ships (6) as shown below");
                player1.placeShips();
                /*
                System.out.println("Player 2, please place your ships (6) as shown below");
                Human player2 = new Human(playerName); */
                //do {

                // }
                // while {
                // }
                break;

            case 2:
                System.out.println("Player VS Computer (PvE)");
                // Human human = new Human(playerName);
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