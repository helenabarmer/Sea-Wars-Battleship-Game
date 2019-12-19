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

        System.out.println(player1 +  "Get ready to battle! ");
        map.printEmptyMap(emptyMap);

        // Game bar with hits
        String hitBarPlayer1 = "";
        String hitBarPlayer2 = "";
        String winBar = "********************";

        // Total hits for players
        int hitsPlayer1 = 0;
        int hitsPlayer2 = 0;

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
            String[] shipNames = {"Submarine", "Destroyer", "Cruiser", "Battleship", "Carrier"};


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

                    if(!playerTwoMap[xShoot][yShoot].contains(ships[i])){
                        for(int j = 0; j<shipNames.length; j++){
                            System.out.println("YOU SUNK " +ships[j] + "\n");
                            battleMap2[xShoot][yShoot] = ships[i];
                        }
                    }

                    // If you have already had a hit on the square
                    if(battleMap2[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have already bombed this area without any luck. " + "\n");
                    }

                    else{
                        System.out.println("HIT!");
                        battleMap2[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += "*";
                        hitsPlayer1++;
                    }
                }
            }

            // If the square does not have a ship placed there
            if(playerTwoMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
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

            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Invalid choice");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShoot][yShoot].contains(ships[i])) {

                if(!playerOneMap[xShoot][yShoot].contains(ships[i])){
                    for(int j = 0; j<shipNames.length; j++){
                        System.out.println("YOU SUNK " +ships[j] + "\n");
                        battleMap1[xShoot][yShoot] = ships[i];
                    }
                }
                    // If you have already had a hit on the square
                    if(battleMap1[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have already bombed this area without any luck. " + "\n");
                    }

                    else{
                        System.out.println("HIT!");
                        battleMap1[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer2 += "*";
                        hitsPlayer2++;
                    }
                }
            }

            // If the grid is empty / miss
            if(playerOneMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMap1[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player1);
            map.printBattle(battleMap1, xShoot, yShoot, "battle");

            // If all ships are hit
            if (hitsPlayer2 == 20) {
                System.out.println(player2 + " WINS! GAME OVER FOR: " + player1);
                break;
            }


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

        ShipType submarine = ShipType.SUBMARINE;
        ShipType destroyer = ShipType.DESTROYER;
        ShipType cruiser = ShipType.CRUISER;
        ShipType battleship = ShipType.BATTLESHIP;
        ShipType carrier1 = ShipType.CARRIER1;
        ShipType carrier2 = ShipType.CARRIER2;


        // Array of ship names
        ShipType[] shipNames = {submarine, destroyer, cruiser, battleship, carrier1, carrier2};

        // Printing the empty map to see the coordinates
        map.printEmptyMap(playerMap);


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

    public void testPrintSize(String shipName, int xInput, int yInput, int size){
        for (int i = 0; i < size; i++) {
            for (int y1 = yInput; y1 <= yInput; y1++) {
                y1 += i;
                for (int x1 = xInput; x1 <= xInput; x1++)


                {}}}
    }


    // Add X and Y coordinates through user input
    public int[] userInputCoordinates(String shipType, int size){

        // How to implement maz size?

        /*for (int i = 0; i < size; i++) {
            for (int y = yInput; y <= yInput; y++) {
                y += i;
                for (int x = xInput; x <= xInput; x++) {}}}*/


        System.out.println("Add X-coordinate for your " + shipType + " with size " + size);
        int xInput = input.nextInt();

        System.out.println("Add Y-coordinate for your " + shipType + " with size " + size);
        int yInput = input.nextInt();

        while (xInput < 0 || xInput > 10) {
            System.out.println("Please Enter Valid Coordinate");
            xInput = input.nextInt();
        }

        while (yInput < 0 || yInput > 10) {
            System.out.println("Please Enter Valid Coordinate");
            yInput = input.nextInt();
        }


        return new int [] {xInput, yInput};

    }

    }



