package com.company;

public enum ShipSize {
    SUBMARINE(3),
    DESTROYER(2),
    CRUISER(4),
    BATTLESHIP(5),
    CARRIER(3);

    private int size;

    ShipSize(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
