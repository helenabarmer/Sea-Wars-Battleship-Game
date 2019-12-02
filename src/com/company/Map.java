package com.company;

// import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
    // User input
    Scanner input = new Scanner(System.in);

    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    //Colours for text
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    // Maximum size for the map, columns and rows
    private int maxColumnMap = 11;
    private int maxRowMap = 11;

    // Map template with grid size from variables (could be user input later on)
    String[][] map = new String [maxColumnMap][maxRowMap];
    ArrayList <Ship> ships = new ArrayList<>();
    //String userMap[][][] = new String[][][];

    
    // Constructor, prints map when object is made
    public Map() {
        //printEmptyMap(map);
    }


    // Printing map with empty squares [ ]
    public void printEmptyMap(String[][] oceanMap) {

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
            System.out.println(ANSI_RED +"|" + column +"Y" + "|" + ANSI_RESET);
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
            System.out.print(ANSI_RED + "" + k + "X" + " | "+ ANSI_RESET);
        }

        // Adding new line after the map prints
        System.out.println("\n");
    }



    public void addCoordinateToMap(int xInput, int yInput){
        // Add coordinates from user input
        for (int y = yInput; y<= yInput; y++) {
            for (int x = xInput; x <= xInput; x++) {
                map[x][y] = "X" ;
                y++;
                for(int y1 = yInput; y1<= yInput; y1++){
                    map[x][y] = "X";
                    y++;
                    for(int y2 = yInput; y2<= yInput; y2++){
                        map[x][y] = "X";
                    }
                }
            }
        }
    }


    public void printPlayerMapShips(String[][] oceanMap, int x, int y) {
        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "      OCEAN MAP      " + ANSI_RESET);
        for(int line=1; line<=map.length;line++){
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // Adding coordinates from user input
        addCoordinateToMap(x, y);


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
        for(int line=1; line<=map.length;line++){
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for(int k = 1; k<=map.length; k++){
            System.out.print(ANSI_RED +" " + k + " | "+ ANSI_RESET);
        }

        // Adding new line after the map prints
        System.out.println("\n");
    }

}

