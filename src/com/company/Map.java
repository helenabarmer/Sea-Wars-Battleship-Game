package com.company;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    // User input
    Scanner input = new Scanner(System.in);

    // Colours for background
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    //Colours for text
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // Maximum size for the map, columns and rows
    private int maxColumnMap = 11;
    private int maxRowMap = 11;

    // Map template with grid size from variables (could be user input later on)
    String[][] map = new String [maxColumnMap][maxRowMap];
    ArrayList <Ship> ships = new ArrayList<>();

    
    // Constructor, prints map when object is made
    public Map() {
        printMap(map);
    }


    // Printing map with empty squares [ ]
    public void printMap(String[][] oceanMap) {

        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "      OCEAN MAP      " + ANSI_RESET);
        for(int line=1; line<map.length;line++){
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // Initialize 2D matrix map
        for (int y = 1; y< map.length; y++) {
            for (int x = 1; x < map.length; x++) {
                map[x][y] = " " ;
            }
        }
        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for(int column = 1; column<map.length; column++){
            String square = "";
            for(int row = 1; row<map.length; row++){
                square+=  " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED +"|" + column + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for(int line=1; line<map.length;line++){
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for(int k = 1; k<map.length; k++){
            System.out.print(ANSI_RED +" " + k + " | "+ ANSI_RESET);
        }
    }


    // Add ship to map, under construction not done
    // Should not be void, should return the ship
    public void addShip(){
        int x;
        int y;
        int length;
        String ship;

        ship = "D";

        System.out.println("Please add the X coordinate for your ship " + ship + ":");
        x = input.nextInt();
        System.out.println("Please add the Y coordinate for your ship " + ship + ":");
        y = input.nextInt();

        //map[x][y] = ship;

    }


}

