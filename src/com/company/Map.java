package com.company;

public class Map {

    private final int maxColumn = 10;
    private final int maxRow = 10;

    String[][] map = new String [maxColumn][maxRow];

    public Map() {

    }

    // Prints the map with [ ] (empty for now)
    /*public void printMap() {

        // Template for the map
        String[][] map = {
                {" 1 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 2 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 3 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 4 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 5 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 6 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 7 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 8 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 9 ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {" 10 "," [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] ", " [ ] "},
                {"   ", "  1  ", "  2  ", "  3  ", "  4  ", "  5  ", "  6  ", "  7  ", "  8  ", "  9  ", " 10 "},
        };

        // Print the grid to console
        for (int row = 0; row < map.length; row++) {
            System.out.println();
            for (int col = 0; col < map[0].length; col++) {
                System.out.print(map[row][col]);
            }
        }
    }*/

    // New version of printing map with empty squares [ ]
    public void printMap(){

        // Initialises the " " between the [ ]
        for(int y=0; y<map.length; y++){
            for(int x = 0; x<map.length; x++){
                map[x][y] = " ";
            }
        }

        // Initialises the empty squares as the game board [ ]
        for(int row = 0; row<map.length; row++){
            String square = "";
            for(int column = 0; column<map.length; column++){
                square+= " [" + map[column][row] + "] ";
            }
            System.out.println(square);
        }
    }


}

