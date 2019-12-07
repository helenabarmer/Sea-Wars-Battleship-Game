package com.company;

import javax.swing.event.AncestorEvent;
import java.util.Scanner;

public class Menu {
    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String WHITE_BACKGROUND = "\033[47m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    // Colours for String
    public static final String BLACK = "\033[0;30m";
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK



    // Creating maps for the players and computer
    String playerOneMap[][] = new String[11][11];
    String playerTwoMap[][] = new String[11][11];
    String computerMap[][] = new String[11][11];

    private Scanner input = new Scanner(System.in);
    private boolean gameStillRunning;

    public boolean isGameStillRunning() {
        return gameStillRunning;
    }

    //Switch case to present MENU; Gives user three options.
    public void Choices() {

        do {


            // TEST TO DRAW SHIP
            System.out.println(
                    RED_BACKGROUND + BLACK_BOLD +"          WELCOME TO SEA WARS!        " + ANSI_RESET +
                            "\n" +  "\n" +

                    "                     " + ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET +
                           ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET +

                            "\n" +
                    "                       " + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET + "\n" +
                    "                       " + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET + "\n" +
                    "                     " + ANSI_WHITE_BACKGROUND + "      " +  ANSI_RESET +
                            "\n" +
                    "                   " + WHITE_BACKGROUND_BRIGHT+ "      " + ANSI_RESET +
                            ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET +
                            "\n" +
                    "   " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                            "      " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                            "      " + ANSI_WHITE_BACKGROUND + "        " +  ANSI_RESET +
                            "      " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +

                            "\n" +

                    "     " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                            BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET +  "    " +
                            WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                            BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET + "  " +
                            WHITE_BACKGROUND_BRIGHT+ "    " + ANSI_RESET +
                            ANSI_WHITE_BACKGROUND +  "  " + ANSI_RESET +
                            WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET + "  "  +

                            BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET +
                            WHITE_BACKGROUND_BRIGHT+  "  " + ANSI_RESET +
                            "\n" +
                    "   " + BLACK_BACKGROUND_BRIGHT + "      " + ANSI_RESET + "  " + BLACK_BACKGROUND_BRIGHT +"      " +
                            ANSI_RESET  + "  " + ANSI_WHITE_BACKGROUND + "        " +  ANSI_RESET +  "  " + BLACK_BACKGROUND_BRIGHT +
                            "      " + ANSI_RESET + "\n" +
                            " " + BLACK_BACKGROUND   + "                                    " + ANSI_RESET + "\n" +
                    "   " + ANSI_WHITE_BACKGROUND + "        " + ANSI_RESET +"  " +
                            ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                            ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                            ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                            ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                            ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                            ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                            ANSI_WHITE_BACKGROUND +"            " + ANSI_RESET + "\n" +
                    "    " + ANSI_WHITE_BACKGROUND + "                              " + ANSI_RESET + "\n" +
                            "      " + ANSI_WHITE_BACKGROUND + "                            " + ANSI_RESET + "\n" +
                           " " + ANSI_BLUE_BACKGROUND + "                                    " + ANSI_RESET + "\n"
            );

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
                //computer.AIPlaceShips(computerMap);

                //computer.shoot(playerOneMap, computerMap, human.getName(), "Computer");


                // Map computerMap = new Map();
                break;
                //do battle {

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