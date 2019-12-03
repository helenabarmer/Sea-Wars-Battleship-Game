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

        if(){
            if (=="S"||==""){

            }
            else if(=="X" || =="*"){
                
            }
            else{
                map[x][y] = "*";
            }
        }
        else {
            if(==""){
            map[x][y] = "X";
            }
        else if(=="X" || =="*"){

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
