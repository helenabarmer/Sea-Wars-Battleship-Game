package com.company;

public abstract class Player {

    private String name;
    public Map playerMap;

    public Player(String name){
        this.name = name;
        playerMap = new Map();
    }

    //Method to shoot on the map
    public void shoot(){

        if(/*Submarine ability on?*/){
            if (map[x][y]=="S"||map[x][y]==""){
//Does it hit a empty space or one with the sub, no changes
            }
            else if(map[x][y]=="X" ||map[x][y] =="*"){

            }
            else{
                map[x][y] = "*";
            }
        }
        else {
            if(map[x][y]==""){
            map[x][y] = "X";
            }
        else if(map[x][y]=="X" || map[x][y]=="*"){

            }
        else{
                map[x][y] = "*";
            }
        }

    }

    // Method to get specific coordinates
    public void getShotCoordinates(){
    }

    public String getName(){
        return this.name;
    }




}
