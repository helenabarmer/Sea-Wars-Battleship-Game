package com.company;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;

public class Ship {
    private int size;
    private int hits;
    private String typeOfShip;
    private boolean isDestroyed = false;
    private boolean vertical;
    private int posX, posY; //position in the map
    private Position[][] positions1;
    Position position;
    ArrayList<Position> positionsArrayList = new ArrayList<>();

    public Ship(String type, int size, int posX, int posY, boolean vertical) {
        positions1 = new Position[posX][posY];
        position = new Position(posX, posY);
        positionsArrayList.add(position);
        this.size = size;
        this.typeOfShip = type;
        this.posX = posX;
        this.posY = posY;
        this.vertical = vertical;
    }

    /*public void setPositions(Position[] positions) {
        this.positions = positions;
    }*/

    public Position[][] getPositions() {
        return this.positions1;
    }

    public ArrayList<Position> getPos(){
        return this.positionsArrayList;
    }

    public int getSize() {
        return this.size;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public boolean getOrientation() {
        return this.vertical;
    }

    public boolean getDestroyed() {
        return this.isDestroyed;
    }

    public String getTypeOfShip() {
        return this.typeOfShip;
    }



    // Printing to Human Class method placeShips()
    public String toString() {
        return "Ship: " + typeOfShip + "\n" +
                "Size: " + size + "\n" +
                "X-position: " + posX + "\n" +
                "Y-position: " + posY + "\n";
    }


}

