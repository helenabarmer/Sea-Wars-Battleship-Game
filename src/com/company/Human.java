package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {
    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Map> maps = new ArrayList<>();
    Map playerOneMap = new Map();

    // Size of map, 10 x 10 grid
    String[][] map = new String[10][10];

    public Human() {
        super("");
    }

    public void placeShips() {
        // Adding ship sizes
        int submarine = 3;
        int destroyer = 2;
        int cruiser = 4;
        int battleship = 5;
        int carrier = 32; // Actual size is 3x2, for simplicity adding 32 for now

        // Array of the ships
        int[] shipSizes = {submarine, destroyer, cruiser, battleship, carrier};

        // Printing the empty map to see the coordinates
        playerOneMap.printEmptyMap(map);

        for (int i = 0; i < shipSizes.length; i++) {

            // Coordinates to be added for the different ships in switch case
            int[]coordinates;

            // Adding ships through switch case, referencing the length of the ships
            switch (shipSizes[i]) {
                case 3:
                    // Reference to method for adding coordinates
                    coordinates = userInputCoordinates("submarine");

                    // Print map with added coordinates
                    playerOneMap.printPlayerMapShips(map, coordinates[0], coordinates[1], submarine);

                    // Add battleship to ships ArrayList
                    Submarine sub = new Submarine(coordinates[0], coordinates[1], true);
                    ships.add(sub);

                    // Printing information about the added ship
                    loopAndPrintShips(sub);
                    break;

                case 2:
                    System.out.println("Destroyer");
                    // Reference to method for adding coordinates
                    coordinates = userInputCoordinates("destroyer");

                    // Print map with added coordinates
                    playerOneMap.printPlayerMapShips(map, coordinates[0], coordinates[1], destroyer);

                    // Add battleship to ships ArrayList
                    Destroyer dest = new Destroyer(coordinates[0], coordinates[1], true);
                    ships.add(dest);

                    // Printing information about the added ship
                    loopAndPrintShips(dest);
                    break;

                case 4:
                    System.out.println("Cruiser");
                    String c = "Cruiser";
                    //testAddCoordinates(c);
                    break;

                case 5:
                    // Reference to method for adding coordinates
                    coordinates = userInputCoordinates("battleship");

                    // Print map with added coordinates
                    playerOneMap.printPlayerMapShips(map, coordinates[0], coordinates[1], battleship);

                    // Add battleship to ships ArrayList
                    BattleShip battleShip = new BattleShip(coordinates[0], coordinates[1], true);
                    ships.add(battleShip);

                    // Printing information about the added ship
                    loopAndPrintShips(battleShip);
                    break;

                case 32:
                    System.out.println("Carrier");
                    break;

                default:
                    System.out.println("Invalid");
                    break;

            }
        }
        // Add map to ArrayList
        maps.add(playerOneMap);
    }

        // Add X and Y coordinates through user input
        private int[] userInputCoordinates(String shipType){
            System.out.println("Add X-coordinate for your " + shipType);
            int xInput = input.nextInt();
            System.out.println("Add Y-coordinate for your " + shipType);
            int yInput = input.nextInt();

            return new int [] {xInput, yInput};
        }

        // Looping through ArrayList of ships and printing them
        public void loopAndPrintShips (Ship ship){
            for (Ship myShip : ships) {
                System.out.println(myShip.toString());
            }

        }
    }


