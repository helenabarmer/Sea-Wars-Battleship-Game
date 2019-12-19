package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Player {
    // Colour for console, background
    private static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Reset colour
    private static final String ANSI_RESET = "\u001B[0m";

    private Map map = new Map();

    // Maps for players vs players and player vs computer
    private String[][] battleMap1 = new String[11][11];
    private String[][] battleMapAI = new String[11][11];

    // Empty map
    private String[][] emptyMap = new String[11][11];

    // User input
    private Scanner input = new Scanner(System.in);


    public Computer() {
        super("Computer");
    }

    public void shootAI(String[][] playerOneMap, String[][] computerMap, String player1, String AI) {

        System.out.println(player1 +  "Get ready to battle! ");
        map.printEmptyMap(emptyMap);

        String hitBarPlayer1 = "";
        String hitBarAI = "";
        String winBar = "********************";
        int hitsPlayer1 = 0;
        int hitsAI = 0;
        Random random = new Random();

        // Initialize 2D matrix map for PLAYER 1
        for (int y = 1; y < battleMap1.length; y++) {
            for (int x = 1; x < battleMap1.length; x++) {
                battleMap1[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        // Initialize 2D matrix map for AI
        for (int y = 1; y < battleMapAI.length; y++) {
            for (int x = 1; x < battleMapAI.length; x++) {
                battleMapAI[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        do {

            String ships[] = {"S", "D", "C", "B", "c"};
            String shipNames[] = {"Submarine", "Destroyer", "Cruiser", "Battleship", "Carrier"};

            // PLAYER 1

            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            int yShoot = input.nextInt();

            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Invalid choice! ");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            for (int i = 0; i < ships.length; i++) {

                if (computerMap[xShoot][yShoot].contains(ships[i])) {

                    if (!computerMap[xShoot][yShoot].contains(ships[i])) {
                        for (int j = 0; j < shipNames.length; j++) {
                            System.out.println("YOU SUNK " + ships[j] + "\n");
                            battleMapAI[xShoot][yShoot] = ships[i];
                        }
                    }

                    // If you have already had a hit on the square
                        if(battleMapAI[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                            System.out.println("You have already bombed this area without any luck. " + "\n");
                        }

                        else{
                            System.out.println("HIT!");
                            battleMapAI[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                            hitBarPlayer1 += "*";
                            hitsPlayer1++;
                        }
                    }
                }


            if (computerMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMapAI[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + AI);
            map.printBattle(battleMapAI, xShoot, yShoot, "battle");
            if (hitsPlayer1 == 20) {
                System.out.println(player1 + " WINS! GAME OVER FOR: " + AI);
                break;
            }



            // AI
            int xShootAI = random.nextInt(10 - 1) + 1;
            int yShootAI = random.nextInt(10 - 1) + 1;

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShootAI][yShootAI].contains(ships[i])) {

                    if (!playerOneMap[xShootAI][yShootAI].contains(ships[i])) {
                        for (int j = 0; j < shipNames.length; j++) {
                            System.out.println("Computer SUNK " + ships[j] + "\n");
                            battleMap1[xShootAI][yShootAI] = ships[i];
                        }
                    }

                    if(!playerOneMap[xShootAI][yShootAI].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("HIT!");
                        battleMap1[xShootAI][yShootAI] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarAI += "*";
                        hitsAI++;
                    }
                    else{
                        System.out.println("You have already bombed this area without any luck. ");
                    }
                }
            }
            if (playerOneMap[xShootAI][yShootAI].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMap1[xShootAI][yShootAI] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player1);
            map.printBattle(battleMap1, xShootAI, yShootAI, "battle");

            if (hitsAI == 20) {
                System.out.println(AI + " WINS! GAME OVER FOR: " + player1);
                break;
            }


            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer1 + ANSI_RESET);
            System.out.println("Number of hits for " + AI + " is: " + hitsAI);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarAI + ANSI_RESET);

        }
        while (true);


    }


    public void AIPlaceShips(String playerMap[][]) {
        // Adding ship sizes

        int submarineSize = ShipSize.SUBMARINE.getSize();
        int destroyerSize = ShipSize.DESTROYER.getSize();;
        int cruiserSize = ShipSize.CRUISER.getSize();
        int battleshipSize = ShipSize.BATTLESHIP.getSize();
        int carrier1Size = ShipSize.CARRIER1.getSize();
        int carrier2Size = ShipSize.CARRIER2.getSize();

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
                    map.printAIMapShips(playerMap, submarineSize, submarine);

                    break;

                case DESTROYER:


                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, destroyerSize, destroyer);


                    break;

                case CRUISER:


                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, cruiserSize, cruiser);


                    break;

                case BATTLESHIP:


                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, battleshipSize, battleship);

                    break;

                case CARRIER1:

                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, carrier1Size, carrier1);

                    break;

                case CARRIER2:
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, carrier2Size, carrier2);

                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }


}