package com.company;

public enum SquareState {

    Human human = new Human;



    String[] ships = {"S","D","C","B","c1","c2"};
        for (int x = 0; x < 6; x++) {
            if ( == ships[x])
         = "[X]"
        }
        else{
            = "[*]"
    }

}
