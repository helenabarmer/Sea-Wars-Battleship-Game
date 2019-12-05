package com.company;

import java.util.Scanner;

public class Menu {

    // Creating maps for the players and computer
    String playerOneMap[][] = new String[11][11];
    String playerTwoMap[][] = new String[11][11];
    Map computerMap[][] = new Map[11][11];

    private Scanner input = new Scanner(System.in);
    private boolean gameStillRunning;

    public boolean isGameStillRunning() {
        return gameStillRunning;
    }

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        do {

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

                    /*
                    System.out.println("Player 2, please type in your name");
                    String playerTwoName = inputFromUser.nextLine();
                    Human player2 = new Human(playerTwoName);
                    System.out.println("Welcome" + " " + player2.getName() + "!" + "\n");
                     */

                    //System.out.println(player1.getName() + " " + ", please place your ships (6) as shown below");
                    //player1.placeShips(playerOneMap);

                    //System.out.println(player1.getName() + " " + ", please place your ships (6) as shown below");
                    //player1.placeShips(playerOneMap);

                /*
                System.out.println("Player 2, please place your ships (6) as shown below");
                Human player2 = new Human(playerName); */


                    System.out.println(player1.getName() + "," + " " + "please place your ships (6) as shown below");
                    player1.placeShips(playerOneMap, player1.getName());


                    System.out.println(player2.getName() + "," + " " + "please place your ships (6) as shown below");
                    player2.placeShips(playerTwoMap, player2.getName());


                    player1.shoot(playerOneMap, playerTwoMap, player1.getName(), player2.getName());

                    break;

                case 2:
                    System.out.println("You have chosen 'Player VS Computer' (PvE)" + "\n \n" + "Please enter your name:");

                    String humanName = inputFromUser.nextLine();
                    Human human = new Human(humanName);
                    System.out.println("Welcome" + " " + human.getName() + "!");

                    // Name of Computer will include automatically via Computer-Class
                    Computer computer = new Computer();
                    System.out.println("You'll be playing against the" + " " + computer.getName() + "\n");

                    System.out.println(human.getName() + "," + " " + "please place your ships (6) as shown below");
                    human.placeShips(playerOneMap, human.getName());
                    // Map computerMap = new Map();
                    break;

                case 3:
                    System.out.println("You will now Quit Sea Wars");
                    System.exit(0); // Shuts down program
            }
        } while (gameStillRunning = true);
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