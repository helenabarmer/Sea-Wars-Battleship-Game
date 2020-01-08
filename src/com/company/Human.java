package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {

    // Colour for console, background
    private static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";

    // Colours for text
    private static final String ANSI_BLUE = "\u001B[34m";

    // Reset colour
    private static final String ANSI_RESET = "\u001B[0m";

    // User input
    private Scanner input = new Scanner(System.in);

    // Object of Map
    private Map map = new Map();

    // Battle maps
   private String[][] battleMap1 = new String[11][11];
   private String[][] battleMap2 = new String[11][11];

   // Empty map
   private String[][] emptyMap = new String[11][11];

   // Constructor
    public Human(String name) {
        super(name);
    }


    public void shoot(String[][] playerOneMap, String[][] playerTwoMap, String player1, String player2){

        System.out.println(player1 +  " get ready to battle! ");
        map.printEmptyMap(emptyMap);

        // Game bar with hits
        String hitBarPlayer1 = "";
        String hitBarPlayer2 = "";
        String winBar = "********************";

        // Total hits for players
        int hitsPlayer1 = 0;
        int hitsPlayer2 = 0;

        // Use count to see if a ship has sunk
        int countPlayer1 = 0;
        int countPlayer2 = 0;

        // Initialize 2D matrix map, player 1
        for (int y = 1; y < battleMap2.length; y++) {
            for (int x = 1; x < battleMap2.length; x++) {
                battleMap2[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        // Initialize 2D matrix map, player 2
        for (int y = 1; y < battleMap1.length; y++) {
            for (int x = 1; x < battleMap1.length; x++) {
                battleMap1[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        do {
            String[] ships = {"S", "D", "C", "B", "c"};

            // PLAYER 1
            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            int yShoot = input.nextInt();

            // Loop to only shoot within the range of the coordinates
            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Invalid choice! ");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }


            // Loop through the map and see if there are ships placed there
            for (int i = 0; i < ships.length; i++) {
                if (playerTwoMap[xShoot][yShoot].contains(ships[i])) {

                    // If you have already had a hit on the square
                    if(battleMap2[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have already bombed this area without any luck. " + "\n");
                    }

                    // Hit adds to the game status bar
                    else{
                        System.out.println("HIT! " + "\n");

                        // Use count to check if ships are sunk
                        countPlayer1++;

                        // If count equals the size of the ships the ships are sunk
                        if(countPlayer1 == ShipSize.SUBMARINE.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.SUBMARINE.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.SUBMARINE + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.DESTROYER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.DESTROYER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.DESTROYER + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CRUISER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CRUISER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CRUISER + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.BATTLESHIP.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.BATTLESHIP.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.BATTLESHIP + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CARRIER1.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER1.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER1 + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CARRIER2.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER2.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER2 + "!");
                            countPlayer1 = 0;
                        }

                        // Update battle map
                        battleMap2[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += SquareState.HIT.getSquareSymbol();
                        hitsPlayer1++;
                    }
                }
            }

            // If the square does not have a ship placed there
            if(playerTwoMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS! " + "\n");
                battleMap2[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player2);
            map.printBattle(battleMap2, xShoot, yShoot, "battle");
            if (hitsPlayer1 == 20) {
                System.out.println(player1 + " WINS! GAME OVER FOR: " + player2);
                break;
            }

            // PLAYER 2
            System.out.println("Your turn to shoot, " + player2 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            yShoot = input.nextInt();

            // To not be able to shoot outside of the grid
            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Invalid choice");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            // Looping through the map and check if the grid is empty or not
            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShoot][yShoot].contains(ships[i])) {

                    // If you have already had a hit on the square
                    if(battleMap1[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have already bombed this area without any luck. " + "\n");
                    }

                    // Hit adds to the game bar
                    else{
                        System.out.println("HIT! " + "\n");

                        // Use count to check if ships are sunk
                        countPlayer2++;

                        // If count equals the size of the ships the ships are sunk
                        if(countPlayer2 == ShipSize.SUBMARINE.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.SUBMARINE.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.SUBMARINE + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.DESTROYER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.DESTROYER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.DESTROYER + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CRUISER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CRUISER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CRUISER + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.BATTLESHIP.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.BATTLESHIP.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.BATTLESHIP + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CARRIER1.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER1.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER1 + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CARRIER2.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER2.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER2 + "!");
                            countPlayer2 = 0;
                        }

                        // Update battle map
                        battleMap1[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer2 += SquareState.HIT.getSquareSymbol();
                        hitsPlayer2++;
                    }
                }
            }

            // If the grid is empty / miss
            if(playerOneMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS! " + "\n");
                battleMap1[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            // Print the map of player 1
            System.out.println("MAP OF PLAYER " + player1);
            map.printBattle(battleMap1, xShoot, yShoot, "battle");

            // If all ships are hit
            if (hitsPlayer2 == 20) {
                System.out.println(player2 + " WINS! GAME OVER FOR: " + player1);
                break;
            }

            // Status for the game
            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer1 + ANSI_RESET);
            System.out.println("Number of hits for " + player2 + " is: " + hitsPlayer2);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer2 + ANSI_RESET);

        }while(true);

    }


    public void placeShips(String[][] playerMap, String playerName) {
        // Adding ship sizes
        int submarineSize = 3;
        int destroyerSize = 2;
        int cruiserSize = 4;
        int battleshipSize = 5;
        int carrier1Size = 3;
        int carrier2Size = 3;

        // Type of ships
        ShipType submarine = ShipType.SUBMARINE;
        ShipType destroyer = ShipType.DESTROYER;
        ShipType cruiser = ShipType.CRUISER;
        ShipType battleship = ShipType.BATTLESHIP;
        ShipType carrier1 = ShipType.CARRIER1;
        ShipType carrier2 = ShipType.CARRIER2;


        // Array of ship types
        ShipType[] shipNames = {submarine, destroyer, cruiser, battleship, carrier1, carrier2};

        // Printing the empty map to see the coordinates
        map.printEmptyMap(playerMap);


        // Looping through and adding the ships one by one
        for (int i = 0; i < shipNames.length; i++) {
            // Coordinates to be added for the different ships in switch case
            int[] coordinates;

            // Adding ships through switch case, referencing the length of the ships
            switch (shipNames[i]) {

                // It's yellow and we all live there
                case SUBMARINE:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, submarineSize, submarine);
                    break;

                case DESTROYER:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, destroyerSize, destroyer);
                    break;

                case CRUISER:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, cruiserSize, cruiser);
                    break;

                case BATTLESHIP:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, battleshipSize, battleship);
                    break;

                case CARRIER1:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, carrier1Size, carrier1);
                    break;

                case CARRIER2:
                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, carrier2Size, carrier2);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}



