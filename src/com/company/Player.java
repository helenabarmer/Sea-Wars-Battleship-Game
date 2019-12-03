package com.company;

public abstract class Player {

    private String name;

    public Player(String name){
        this.name = name;
    }

    //Method to shoot on the gameboard
    public void shoot(){

    }

    // Method to get specific coordinates
    public void getShotCoordinates(){
    }

    public String getName(){
        return this.name;
    }



}
