package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player{
    Scanner input = new Scanner (System.in);
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Map> maps = new ArrayList<>();
    Map playerOneMap = new Map();
    ArrayList<Position>positions = new ArrayList<>();

    // Size of map, 10 x 10 grid
    String[][] map = new String[10][10];

    public Human(){
        super("");
    }

    public void placeShips(){
        playerOneMap.printEmptyMap(map);
        System.out.println("Add X-coordinate for your battleship: ");
        int xInput = input.nextInt();
        System.out.println("Add Y-coordinate for your battleship: ");
        int yInput = input.nextInt();

        // Add battleship to ArrayList
        BattleShip battleShip = new BattleShip(xInput, yInput, true);
        ships.add(battleShip);


        // Print player map with x- and y coordinates
        playerOneMap.printPlayerMapShips(map, xInput, yInput);

        // Add map to arraylist
        maps.add(playerOneMap);

        // Printing information about the added ship
        loopAndPrintShips(battleShip);
    }

    // Looping through ArrayList of ships and printing them
    public void loopAndPrintShips(Ship ship){
        for(Ship myShip: ships){
            System.out.println(myShip.toString());
        }

    }
}
