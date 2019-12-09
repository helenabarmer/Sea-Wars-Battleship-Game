package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Player {
Map map = new Map();

    String battleMap1[][] = new String[11][11];
    String battleMapAI[][] = new String[11][11];

    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();

    public Computer() {
        super("Computer");
    }

    public void shoot(String playerOneMap[][], String computerMap[][], String player1, String AI){
        boolean gameOver = true;
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
                    battleMapAI[xShoot][yShoot] = SquareState.HIT.getSquareSymbol();
                    hitsPlayer1++;
                }
            }if(computerMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMapAI[xShoot][yShoot] = SquareState.MISS.getSquareSymbol();
            }

            System.out.println("MAP OF COMPUTER " + AI);
            map.printBattle(battleMapAI, xShoot, yShoot, "battle");

            if (hitsPlayer1 == 20) {
                System.out.println(player1 + "WINS! GAME OVER FOR: " + AI);
                break;
            }

            // AI
            int xShootAI = random.nextInt(10);
            int yShootAI = random.nextInt(10);

            /*while (xShoot < 1 || xShoot > 10) {
                xShoot = random.nextInt();
            }

            while (yShoot < 1 || yShoot > 10) {
                yShoot = random.nextInt();
            }*/


            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShoot][yShoot].contains(ships[i])) {
                    System.out.println("HIT!");
                    battleMap1[xShootAI][yShootAI] = SquareState.HIT.getSquareSymbol();
                    hitsAI++;

                }
            } if(playerOneMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMap1[xShootAI][yShootAI] = SquareState.MISS.getSquareSymbol();
            }

            System.out.println("MAP OF PLAYER " + player1);
            map.printBattle(battleMap1, xShootAI, yShootAI, "battle");

            if (hitsAI == 20) {
                System.out.println(AI + "WINS! GAME OVER FOR: " + player1);
                break;
            }


            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println("Number of hits for " + AI + " is: " + hitsAI);

        }while(gameOver);


    }


    /*public void AIPlaceShips(String playerMap[][]) {
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
                    // Method for adding coordinates
                    //coordinates = AIRandomCoordinates(typeSubmarine, submarineSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, submarineSize, typeSubmarine);

                    // Add submarine to ships ArrayList
                    //Submarine sub = new Submarine(coordinates[0], coordinates[1], true);
                    //ships.add(sub);

                    //Printing information about the added ship
                    //System.out.println(sub.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(sub);
                    break;

                case "destroyer":
                    // Method for adding coordinates
                    coordinates = AIRandomCoordinates(typeDestroyer, destroyerSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], destroyerSize, typeDestroyer);

                    // Add destroyer to ships ArrayList
                    Destroyer dest = new Destroyer(coordinates[0], coordinates[1], true);
                    ships.add(dest);

                    //Printing information about the added ship
                    System.out.println(dest.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(dest);
                    break;

                case "cruiser":
                    // Method for adding coordinates
                    coordinates = AIRandomCoordinates(typeCruiser, cruiserSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], cruiserSize, typeCruiser);

                    // Add cruiser to ships ArrayList
                    Cruiser crus = new Cruiser(coordinates[0], coordinates[1], true);
                    ships.add(crus);

                    //Printing information about the added ship
                    System.out.println(crus.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(crus);
                    break;

                case "battleship":
                    // Method for adding coordinates
                    coordinates = AIRandomCoordinates(typeBattleship, battleshipSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], battleshipSize, typeBattleship);

                    // Add battleship to ships ArrayList
                    BattleShip battleShip = new BattleShip(coordinates[0], coordinates[1], true);
                    ships.add(battleShip);

                    //Printing information about the added ship
                    System.out.println(battleShip.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(battleShip);
                    break;

                case "carrier1":
                    // Method for adding coordinates
                    coordinates = AIRandomCoordinates(typeCarrier1, carrier1Size);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], carrier1Size, typeCarrier1);

                    // Add carrier ships ArrayList
                    Carrier carrier = new Carrier(coordinates[0], coordinates[1], true);
                    //String shipType = carr.getType();
                    ships.add(carrier);

                    //Printing information about the added ship
                    System.out.println(carrier.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(carrier);
                    break;

                case "carrier2":
                    // Method for adding coordinates
                    coordinates = AIRandomCoordinates(typeCarrier2, carrier2Size);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], carrier2Size, typeCarrier2);

                    // Add carrier ships ArrayList
                    Carrier carrier2 = new Carrier(coordinates[0], coordinates[1], true);
                    //String shipType = carr.getType();
                    ships.add(carrier2);

                    //Printing information about the added ship
                    System.out.println(carrier2.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(carrier);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
}*/
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
