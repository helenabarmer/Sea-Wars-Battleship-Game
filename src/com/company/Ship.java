package com.company;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Ship {
    private int size;
    private String typeOfShip;
    private int posX, posY; //position in the map
    private ArrayList<Position> positionsArrayList = new ArrayList<>();

    public Ship(String type, int size, int posX, int posY) {
        this.size = size;
        this.typeOfShip = type;
        this.posX = posX;
        this.posY = posY;

        Position position = new Position(this.posX, this.posY);
        positionsArrayList.add(position);
    }

    private int getSize() {
        return this.size;
    }

    private int getPosX() {
        return this.posX;
    }

    private int getPosY() {
        return this.posY - 1;
    }

    // Printing
    public String toString() {
        return  "You have added the following ship: " +  "\n" +
                "Type of ship: " + typeOfShip + "\n" +
                "Size: " + getSize() + "\n" +
                "X-position: " + getPosX() + "\n" +
                "Y-position: " + getPosY() + "\n";
    }


}

