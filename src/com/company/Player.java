package com.company;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    public Map playerMap;

    public Player(String name){
        this.name = name;
        playerMap = new Map();
    }

    //Method to shoot on the map
    public void shoot(){

/*
        if(){
            if (map[x][y]=="S"||map[x][y]==""){

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
*/
    }

    // Method to get specific coordinates
    public void getShotCoordinates(){
    }

    public String getName(){
        return this.name;
    }



*/
}
