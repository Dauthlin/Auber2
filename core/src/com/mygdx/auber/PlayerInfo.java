package com.mygdx.auber;

import com.mygdx.auber.entities.Player;

public class PlayerInfo {
    private float x;
    private float y;
    private float health;
    public PlayerInfo() {
        this.x = Player.x;
        this.y = Player.y;
        this.health= Player.health;
//        System.out.println("hello");
//        System.out.println(this.x);
//        System.out.println(this.y);
//        System.out.println("bye");
    }
}
