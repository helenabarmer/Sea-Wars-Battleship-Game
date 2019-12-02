package com.company;

public class Ship {
    private int size;
    private int hits;
private String typeOfShip;
    private boolean isDestroyed = false;
    private boolean vertical;
    private int posX, posY; //position in the map
    private Position[] positions;

    public Ship(String type, int size, int posX, int posY, boolean vertical) {
        positions = new Position[size];
        this.size = size;
        this.typeOfShip = type;
        this.posX = posX;
        this.posY = posY;
        this.vertical = vertical;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Position[] getPositions() {
        return this.positions;
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

    }
}
