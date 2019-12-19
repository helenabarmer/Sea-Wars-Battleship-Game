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

    Map map = new Map();

    String battleMap1[][] = new String[11][11];
    String battleMapAI[][] = new String[11][11];

    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();

    public Computer() {
        super("Computer");
    }

    public void shootAI(String playerOneMap[][], String computerMap[][], String player1, String AI) {
        boolean gameOver = true;
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

            for (int i = 0; i < ships.length; i++) {
                if (computerMap[xShoot][yShoot].contains(ships[i])) {
                    System.out.println("HIT!");

                    if (!computerMap[xShoot][yShoot].contains(ships[i])) {
                        for (int j = 0; j < shipNames.length; j++) {
                            System.out.println("YOU SUNK " + ships[j] + "\n");
                            battleMapAI[xShoot][yShoot] = ships[i];
                        }
                    }
                    battleMapAI[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + "*" + ANSI_RESET + ANSI_BLUE;
                    battleMapAI[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                    hitBarPlayer1 += "*";
                    hitsPlayer1++;
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

            int xShootAI = random.nextInt(11);
            int yShootAI = random.nextInt(11);

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShootAI][yShootAI].contains(ships[i])) {
                    System.out.println("HIT!");

                    if (!playerOneMap[xShootAI][yShootAI].contains(ships[i])) {
                        for (int j = 0; j < shipNames.length; j++) {
                            System.out.println("Computer SUNK " + ships[j] + "\n");
                            battleMap1[xShootAI][yShootAI] = ships[i];
                        }
                    }
                    battleMap1[xShootAI][yShootAI] = RED_BACKGROUND_BRIGHT + "*" + ANSI_RESET + ANSI_BLUE;
                    battleMap1[xShootAI][yShootAI] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                    hitBarAI += "*";
                    hitsAI++;
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
        while (gameOver);
    }


    public void AIPlaceShips(String playerMap[][]) {
        // Adding ship sizes
        int submarineSize = 3;
        int destroyerSize = 2;
        int cruiserSize = 4;
        int battleshipSize = 5;
        int carrier1Size = 3;
        int carrier2Size = 3;

        String typeSubmarine = "submarine";
        String typeDestroyer = "destroyer";
        String typeCruiser = "cruiser";
        String typeBattleship = "battleship";
        String typeCarrier1 = "carrier1";
        String typeCarrier2 = "carrier2";

        // Array of ship names
        String[] shipNames = {typeSubmarine, typeDestroyer, typeCruiser, typeBattleship, typeCarrier1, typeCarrier2};

        // Printing the empty map to see the coordinates
        map.printEmptyMap(playerMap);


        for (int i = 0; i < shipNames.length; i++) {
            // Coordinates to be added for the different ships in switch case
            int[] coordinates;

            // Adding ships through switch case, referencing the length of the ships
            switch (shipNames[i]) {

                // It's yellow and we all live there
                case "submarine":

                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, submarineSize, typeSubmarine);
                    break;

                case "destroyer":
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, destroyerSize, typeDestroyer);
                    break;

                case "cruiser":
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, cruiserSize, typeCruiser);
                    break;

                case "battleship":
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, battleshipSize, typeBattleship);
                    break;

                case "carrier1":
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, carrier1Size, typeCarrier1);
                    break;

                case "carrier2":
                    // Print map with added coordinates
                    map.printAIMapShips(playerMap, carrier2Size, typeCarrier2);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    // Looping through ArrayList of ships and printing information about them
    public void loopAndPrintShips() {
        for (Ship myShip : ships) {
            System.out.println(myShip.toString());
        }
    }
}