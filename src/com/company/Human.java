package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {

    Scanner input = new Scanner(System.in);
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Map> maps = new ArrayList<>();
    ArrayList<Position> positions = new ArrayList<>();

    Map map = new Map();

    // Testing to set size from human to map
    String testMap[][] = new String[11][11];

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

    public void shoot(String playerMap[][]){

        int hitCount = 0;

        // Initialize 2D matrix map
        for (int y = 1; y < testMap.length; y++) {
            for (int x = 1; x < testMap.length; x++) {
                testMap[x][y] = " ";
            }}

        for(int i =0; i<=5; i++){
        System.out.println("Shoot! Enter X-coordinate: ");
        int xShoot = input.nextInt();
        System.out.println("Shoot! Enter Y-coordinate: ");
        int yShoot = input.nextInt();

                    if (playerMap[xShoot][yShoot].contains("S")) {
                        System.out.println("HIT!");
                        testMap[xShoot][yShoot] = "*";
                        hitCount++;
                    }
                    else if (playerMap[xShoot][yShoot].contains("D")) {
                        System.out.println("HIT!");
                        testMap[xShoot][yShoot] = "*";
                        hitCount++;
                    }

                    else if (playerMap[xShoot][yShoot].contains("C")) {
                        System.out.println("HIT!");
                        testMap[xShoot][yShoot] = "*";
                        hitCount++;
                    }
                    else if (playerMap[xShoot][yShoot].contains("B")) {
                        System.out.println("HIT!");
                        testMap[xShoot][yShoot] = "*";
                        hitCount++;
                    }
                    else if (playerMap[xShoot][yShoot].contains("c")) {
                        System.out.println("HIT!");
                        testMap[xShoot][yShoot] = "*";
                        hitCount++;
                    }
                    else if(playerMap[xShoot][yShoot].contains(" ")) {
                        System.out.println("MISS!");
                        testMap[xShoot][yShoot] = "X";
                    }

            System.out.println("Number of hits: " + hitCount);

                map.printBattle(testMap, xShoot, yShoot, "battle");
        }
        }


    public void placeShips(String playerMap[][]) {
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
                    coordinates = userInputCoordinates(typeSubmarine, submarineSize);

                    // Print map with added coordinates
                    map.printPlayerMapShips(playerMap, coordinates[0], coordinates[1], submarineSize, typeSubmarine);

                    // Add submarine to ships ArrayList
                    Submarine sub = new Submarine(coordinates[0], coordinates[1], true);
                    ships.add(sub);

                    //Printing information about the added ship
                    System.out.println(sub.toString());

                    // Printing information about the added ship
                    //loopAndPrintShips(sub);
                    break;

                case "destroyer":
                    // Method for adding coordinates
                    coordinates = userInputCoordinates(typeDestroyer, destroyerSize);

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
                    coordinates = userInputCoordinates(typeCruiser, cruiserSize);

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
                    coordinates = userInputCoordinates(typeBattleship, battleshipSize);

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
                    coordinates = userInputCoordinates(typeCarrier1, carrier1Size);

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
                    coordinates = userInputCoordinates(typeCarrier2, carrier2Size);

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

        // Add map to ArrayList
        //maps.add(playerMap);

        // TEST
        for(Ship ship: ships){
            System.out.println("TEST! "+ship.getPos());
        }

        System.out.println(map.positions.toString());
        //shoot();
        shoot(playerMap);
    }


    // Add X and Y coordinates through user input
    private int[] userInputCoordinates(String shipType, int size){
        System.out.println("Add X-coordinate for your " + shipType + " with size " + size);
        int xInput = input.nextInt();
        System.out.println("Add Y-coordinate for your " + shipType + " with size " + size);
        int yInput = input.nextInt();

        return new int [] {xInput, yInput};
    }

        // Looping through ArrayList of ships and printing information about them
        public void loopAndPrintShips (){
            for (Ship myShip : ships) {
                System.out.println(myShip.toString());
            }

        }
    }


