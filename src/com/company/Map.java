package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Map {
    // User input
    Scanner input = new Scanner(System.in);



    // ArrayList Ship
    ArrayList<Ship> ships = new ArrayList<>();

    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";

    //Colours for text
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLACK_BOLD = "\033[1;30m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    //Constant size for the map
    public final static int MAP_SIZE = 11;

    // Map template with grid size from variables (could be user input later on)
    //String[][] map = new String[MAP_SIZE][MAP_SIZE];

    // Constructor
    public Map() {
    }


    // Printing map with empty squares [ ]
    public void printEmptyMap(String map[][]) {

        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // Initialize 2D matrix map
        for (int y = 1; y < map.length; y++) {
            for (int x = 1; x < map.length; x++) {
                map[x][y] = " ";
            }
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );
        // Adding new line after the map prints
        System.out.println("\n");
    }

    private void AIRandomCoordinatesToMap(String map[][], int size, String shipType){

            Random random = new Random();

            int randomX = random.nextInt(11);

            while (randomX < 0 || randomX > 10) {
                randomX = random.nextInt();
            }

            int randomY = random.nextInt(11);
        while (randomY < 0 || randomY>8 && shipType.equals("submarine")) {
            randomY = random.nextInt();
        }

        while (randomY < 0 || randomY>9 && shipType.equals("destroyer")) {
            randomY = random.nextInt();
        }

        while (randomY < 0 || randomY>7 && shipType.equals("cruiser")) {
            randomY = random.nextInt();
        }

        while (randomY < 0 || randomY>6 && shipType.equals("battleship")) {
            randomY = random.nextInt();
        }

        while (randomY < 0 || randomY>8 && shipType.equals("carrier")) {
            randomY = random.nextInt();
        }

        for (int i = 0; i < size; i++) {
            for (int y = randomY; y <= randomY; y++) {
                y += i;
                for (int x = randomX; x <= randomX; x++) {

                    switch (shipType) {
                        case "submarine":
                            map[x][y] = YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S" + ANSI_RESET + ANSI_BLUE;
                            //positionSubmarine = new Position(randomX, randomY);
                            //10
                            // positions.add(positionSubmarine);
                            break;

                        case "destroyer":
                            map[x][y] = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "cruiser":
                            map[x][y] = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "battleship":
                            map[x][y] = PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "carrier1":
                            map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "carrier2":
                            map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "battle":
                            map[x][y] = " ";
                            break;

                        default:
                            System.out.println("Invalid");
                            break;
                    }
                }
            }
        }

            //System.out.printf("Computer shoots at: (%d,%d) \n", randomX, randomY);
            //return new int [] {randomX, randomY};
        }


    // Add coordinates and ships to map
    public void addCoordinateToMap(String map[][], int size, String shipType) {

        try{
        System.out.println("Add X-coordinate for your " + shipType + " with size " + size);
        int xInput = input.nextInt();

        System.out.println("Add Y-coordinate for your " + shipType + " with size " + size);
        int yInput = input.nextInt();

        while (xInput < 1 || xInput > 10) {
            System.out.println("Please Enter Valid X- Coordinate");
            xInput = input.nextInt();
        }

        while (yInput < 1 || yInput>8 && shipType.equals("submarine")) {
            System.out.println("Please Enter Valid Y-Coordinate");
            yInput = input.nextInt();
        }

        while (yInput < 1 || yInput>9 && shipType.equals("destroyer")) {
            System.out.println("Please Enter Valid Y-Coordinate");
            yInput = input.nextInt();
        }

        while (yInput < 1 || yInput>7 && shipType.equals("cruiser")) {
            System.out.println("Please Enter Valid Y-Coordinate");
            yInput = input.nextInt();
        }

        while (yInput < 1 || yInput>6 && shipType.equals("battleship")) {
            System.out.println("Please Enter Valid Y-Coordinate");
            yInput = input.nextInt();
        }

        while (yInput < 1 || yInput>8 && shipType.equals("carrier")) {
            System.out.println("Please Enter Valid Y-Coordinate");
            yInput = input.nextInt();
        }
        

            for (int i = 0; i < size; i++) {
                for (int y = yInput; y <= yInput; y++) {
                    y += i;
                    for (int x = xInput; x <= xInput; x++) {

                        switch (shipType) {
                            case "submarine":
                                map[x][y] = YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S" + ANSI_RESET + ANSI_BLUE;
                                Submarine submarine = new Submarine(x, y, true);
                                ships.add(submarine);
                                break;

                            case "destroyer":
                                map[x][y] = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D" + ANSI_RESET + ANSI_BLUE;
                                break;

                            case "cruiser":
                                map[x][y] = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C" + ANSI_RESET + ANSI_BLUE;
                                break;

                            case "battleship":
                                map[x][y] = PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B" + ANSI_RESET + ANSI_BLUE;
                                break;

                            case "carrier1":
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                                break;

                            case "carrier2":
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                                break;

                            case "battle":
                                map[x][y] = " ";
                                break;

                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }
                }
            }
        }
        catch (InputMismatchException e){
            e.getMessage();
        }
        }


    public void printPlayerMapShips(String map[][], int size, String shipType) {

        // Adding coordinates from user input
        addCoordinateToMap(map, size, shipType);

        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );

        // Adding new line after the map prints
        System.out.println("\n");
    }


    public void printAIMapShips(String map[][], int size, String shipType) {

        // AI adds random coordinates
        AIRandomCoordinatesToMap(map, size, shipType);

        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );

        // Adding new line after the map prints
        System.out.println("\n");
    }

    
    public void printBattle(String map[][],  int x, int y, String battle) {
        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                RED_BACKGROUND_BRIGHT  + WHITE_BOLD + "HIT (*) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "MISS (X) " + ANSI_RESET + " "
        );
        // Adding new line after the map prints
        System.out.println("\n");
    }

}


