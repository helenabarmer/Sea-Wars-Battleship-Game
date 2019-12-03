package com.company;

import java.util.Random;

public class Computer extends Player{

    public Computer() {
        super("Computer");
    }

public Position getShootCoordinates(){
    Random random = new Random();
    Position position = new Position(random.nextInt(Map.MAP_SIZE), random.nextInt(Map.MAP_SIZE));
    System.out.println("Computer shoots at: ( "+ position.x + "," + position.y + ")");
    return position;
}
}
