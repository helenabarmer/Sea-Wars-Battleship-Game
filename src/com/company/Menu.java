package com.company;

import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    // Get "battle" to start the battle through the BattleShipProgram
    // BattleShipProgram battle = new BattleShipProgram();

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        System.out.println("Welcome to Sea Wars! Please select mode using key 1, 2 or 3. Press <ENTER>");
        System.out.println("1. Player VS Player (PvP)");
        System.out.println("2. Player VS Computer (PvE)");
        System.out.println("3. Quit");
        int userChoice = input.nextInt();
        Scanner inputFromUser = new Scanner(System.in);

        switch (userChoice) {
            case 1:
                System.out.println("You have chosen 'Player VS Player' (PvP)" + "\n");

                System.out.println("Player 1, please type in your name");
                String playerOneName = inputFromUser.nextLine();
                Human player1 = new Human(playerOneName); // playerOneName is the input from user.
                System.out.println("Welcome" + " " + player1.getName() + "!" + "\n");

                System.out.println("Player 2, please type in your name");
                String playerTwoName = inputFromUser.nextLine();
                Human player2 = new Human(playerTwoName);
                System.out.println("Welcome" + " " + player2.getName() + "!" + "\n");

                System.out.println(player1.getName() + "," + " " + "please place your ships (6) as shown below");
                player1.placeShips();

                System.out.println(player2.getName() + "," + " " + "please place your ships (6) as shown below");
                player2.placeShips();

                //do {
                        // We use player1 and player2 in the do-while-loop, where we toggle turns.
                // }
                // while {
                // }
                // break;

            case 2:
                System.out.println("You have chosen 'Player VS Computer' (PvE)" + "\n \n" + "Please enter your name:");

                String humanName = inputFromUser.nextLine();
                Human human = new Human(humanName);
                System.out.println("Welcome" + " " + human.getName() + "!");

                // Name of Computer will include automatically via Computer-Class
                Computer computer = new Computer();
                System.out.println("You'll be playing against the" + " " + computer.getName() + "\n");

                System.out.println(human.getName() + "," + " " + "please place your ships (6) as shown below");
                human.placeShips();
                // Map computerMap = new Map();
                break;
                //do battle {

                // }
                // while {
                // }
            case 3:
                System.out.println("You will now Quit Sea Wars");
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