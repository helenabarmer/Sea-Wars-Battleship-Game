package com.company;

public class Human extends Player{

    Map myMap = new Map();






    public Human(){
        super("");
    }

    public void placeShips(int x, int y){
        String[][] map = new String [x][y];
        //addCoordinateToMap(x, y);
        int xInput =8;
        int yInput = 1;

        // Initialize 2D matrix map
        for (y = yInput; y<= yInput; y++) {
            for (x = xInput; x <= xInput; x++) {
                map[x][y] = " X " ;
                y++;
                for(int y1 = yInput; y1<= yInput; y1++){
                    map[x][y] = " X ";
                    y++;
                    for(int y2 = yInput; y2<= yInput; y2++){
                        map[x][y] = " X ";
                    }
                }
            }
        }

    }


}
