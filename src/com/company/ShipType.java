package com.company;

public enum ShipType {
    SUBMARINE("S"),
    DESTROYER("D"),
    CRUISER("C"),
    BATTLESHIP("B"),
    CARRIER("c");

    private String shipType;

    ShipType(String shipType){
        this.shipType = shipType;
    }

    public String getShipType() {
        return shipType;
    }

}
