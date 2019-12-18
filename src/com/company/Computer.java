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
    private static final String ANSI_RESET = "\u001B[0m" ;

    Map map = new Map();

    String battleMap1[][] = new String[11][11];
    String battleMapAI[][] = new String[11][11];

    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();

    public Computer() {
        super("Computer");
    }

    public void shootAI(String playerMap[][], String computerMap[][], String player1, String AI){
        boolean gameOver = true;
        String hitBarPlayer1 = "";
        String hitBarAI = "";
        String winBar = "********************";
        int hitsPlayer1 = 0;
        int hitsAI = 0;
        Random random = new Random();

        // Initialize 2D matrix map for PLAYER 1
        for (int y = 1; y < battleMapAI.length; y++) {
                for (int x = 1; x < battleMapAI.length; x++) {
                    battleMapAI[x][y] = SquareState.NONE.getSquareSymbol();
                }
        }

        // Initialize 2D matrix map for AI
        for (int y = 1; y < battleMap1.length; y++) {
            for (int x = 1; x < battleMap1.length; x++) {
                battleMap1[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        do {

            String ships[] = {"S", "D", "C", "B", "c"};

            // PLAYER 1

            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            int yShoot = input.nextInt();

            for (int i = 0; i < ships.length; i++) {
                if (computerMap[xShoot][yShoot].contains(ships[i])) {
                    System.out.println("HIT!");
                    battleMapAI[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + "*" + ANSI_RESET + ANSI_BLUE;
                    hitBarPlayer1 += "*";
                    hitsPlayer1++;
                }
            }if(computerMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMapAI[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + "X" + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF COMPUTER " + AI);
            map.printBattle(battleMapAI, xShoot, yShoot, "battle");

            if (hitsPlayer1 == 20) {
                System.out.println(player1 + " WINS! GAME OVER FOR: " + AI);
                break;
            }

            // AI
            int xShootAI = random.nextInt(11);
            int yShootAI = random.nextInt(11);

            while (xShootAI < 1 || xShootAI > 10) {
                xShootAI = random.nextInt();
            }

            while (yShootAI < 1 || yShootAI > 10) {
                yShootAI = random.nextInt();
            }


            for (int i = 0; i < ships.length; i++) {
                if (playerMap[xShootAI][yShootAI].contains(ships[i])) {
                    System.out.println("HIT!");
                    battleMap1[xShootAI][yShootAI] = RED_BACKGROUND_BRIGHT + "*" + ANSI_RESET + ANSI_BLUE;
                    hitBarAI+= "*";
                    hitsAI++;
                }
            }
            if(playerMap[xShootAI][yShootAI].contains(" ")) {
                System.out.println("MISS!");
                battleMap1[xShootAI][yShootAI] = BLACK_BACKGROUND_BRIGHT + "X" + ANSI_RESET + ANSI_BLUE;
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

        }while(gameOver);
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
                    map.printAIMapShips(playerMap, battleshipSize, typeBattleship);
                    break;

                case "carrier1":
                    map.printAIMapShips(playerMap, carrier1Size, typeCarrier1);
                    break;

                case "carrier2":
                    map.printAIMapShips(playerMap, carrier2Size, typeCarrier2);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
}
    // random X and Y coordinates
    private int[] AIRandomCoordinates(String shipType, int size){
        Random random = new Random();

        int randomX = random.nextInt(11);

        while (randomX < 1 || randomX > 10) {
            randomX = random.nextInt();
        }

        int randomY = random.nextInt(11);

        while (randomY < 1 || randomY > 10) {
            randomY = random.nextInt();
        }
        //System.out.printf("Computer shoots at: (%d,%d) \n", randomX, randomY);
        return new int [] {randomX, randomY};
    }

    // Looping through ArrayList of ships and printing information about them
    public void loopAndPrintShips (){
        for (Ship myShip : ships) {
            System.out.println(myShip.toString());
        }
    }
}
