package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {

    // Colour for console, background
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";

    // Colours for text
    public static final String ANSI_BLUE = "\u001B[34m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Map> maps = new ArrayList<>();
    ArrayList<Position> positions = new ArrayList<>();

    Map map = new Map();

    // Testing to set size from human to map
    String testMap[][] = new String[11][11];
    String battleMap1[][] = new String[11][11];
    String battleMap2[][] = new String[11][11];

    Submarine sub;
    Position position;

    public Human(String name) {
        super(name);
        // Keep printed string above, otherwise "name" won't be useful.

    }

    // All added coordinates
    public void getShotCoordinates() {
        for(Ship ship: ships){
            System.out.println(ship.getPosX());
            System.out.println(ship.getPosY());
        }
    }

    public void shoot(String playerOneMap[][], String playerTwoMap[][], String player1, String player2) {

        boolean gameOver = true;
        String hitBarPlayer1 = "";
        String hitBarPlayer2 = "";
        String winBar = "********************";
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

            String ships[] = {"S", "D", "C", "B", "c"};

            // PLAYER 1


            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            int yShoot = input.nextInt();


                for (int i = 0; i < ships.length; i++) {
                    if (playerTwoMap[xShoot][yShoot].contains(ships[i])) {
                        System.out.println("HIT!");
                        battleMap2[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += "*";
                        hitsPlayer1++;
                    }
                }if(playerTwoMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                    System.out.println("MISS!");
                    battleMap2[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                }
            System.out.println("MAP OF PLAYER " + player2);
            map.printBattle(battleMap2, xShoot, yShoot, "battle");
                if (hitsPlayer1 == 20) {
                    System.out.println(player1 + "WINS! GAME OVER FOR: " + player2);
                    break;
                }

            // PLAYER 2
            System.out.println("Your turn to shoot, " + player2 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            yShoot = input.nextInt();

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShoot][yShoot].contains(ships[i])) {
                    System.out.println("HIT!");
                    battleMap1[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                    hitBarPlayer2+= "*";
                    hitsPlayer2++;
                }
            }
            if(playerOneMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMap1[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player1);
            map.printBattle(battleMap1, xShoot, yShoot, "battle");

            if (hitsPlayer2 == 20) {
                System.out.println(player2 + " WINS! GAME OVER FOR: " + player1);
                break;
            }

            //map.printBattle(battleMap2, xShoot, yShoot, "battle");
            //map.printBattle(battleMap1, xShoot, yShoot, "battle");

            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer1 + ANSI_RESET);
            System.out.println("Number of hits for " + player2 + " is: " + hitsPlayer2);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer2 + ANSI_RESET);


        }while(gameOver);

    }


    public void placeShips(String playerMap[][], String playerName) {
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
                    //coordinates = userInputCoordinates(typeSubmarine, submarineSize);

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
                    //coordinates = userInputCoordinates(typeDestroyer, destroyerSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, destroyerSize, typeDestroyer);

                    // Add destroyer to ships ArrayList
                    //Destroyer dest = new Destroyer(coordinates[0], coordinates[1], true);
                    //ships.add(dest);

                    //Printing information about the added ship
                    //System.out.println(dest.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(dest);
                    break;

                case "cruiser":
                    // Method for adding coordinates
                    //coordinates = userInputCoordinates(typeCruiser, cruiserSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, cruiserSize, typeCruiser);

                    // Add cruiser to ships ArrayList
                    //Cruiser crus = new Cruiser(coordinates[0], coordinates[1], true);
                    //ships.add(crus);

                    //Printing information about the added ship
                    //System.out.println(crus.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(crus);
                    break;

                case "battleship":
                    // Method for adding coordinates
                    //coordinates = userInputCoordinates(typeBattleship, battleshipSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, battleshipSize, typeBattleship);

                    // Add battleship to ships ArrayList
                    //BattleShip battleShip = new BattleShip(coordinates[0], coordinates[1], true);
                    //ships.add(battleShip);

                    //Printing information about the added ship
                    //System.out.println(battleShip.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(battleShip);
                    break;

                case "carrier1":
                    // Method for adding coordinates
                    //coordinates = userInputCoordinates(typeCarrier1, carrier1Size);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, carrier1Size, typeCarrier1);

                    // Add carrier ships ArrayList
                    //Carrier carrier = new Carrier(coordinates[0], coordinates[1], true);
                    //String shipType = carr.getType();
                    //ships.add(carrier);

                    //Printing information about the added ship
                    //System.out.println(carrier.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(carrier);
                    break;

                case "carrier2":
                    // Method for adding coordinates
                    //coordinates = userInputCoordinates(typeCarrier2, carrier2Size);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, carrier2Size, typeCarrier2);

                    // Add carrier ships ArrayList
                    //Carrier carrier2 = new Carrier(coordinates[0], coordinates[1], true);
                    //String shipType = carr.getType();
                    //ships.add(carrier2);

                    //Printing information about the added ship
                    //System.out.println(carrier2.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(carrier);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }

        // Add map to ArrayList
        //maps.add(playerMap);

        // TEST
        /*for(Ship ship: ships){
            System.out.println("! "+ship.getPos());
        }*/

        //loopAndPrintShips();
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

        // Looping through ArrayList of ships and printing information about them
        public void loopAndPrintShips (){
            for (Ship myShip : ships) {
                System.out.println(myShip.toString());
            }
        }
    }


