package com.company;

public class Carrier extends Ship {
    //It should be 2 unit Carrier in Map
    public Carrier(int posX, int posY, boolean vertical){
        super("Carrier", 3, posX, posY, vertical);
    }
}
