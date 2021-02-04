package com.mygdx.auber.Models;

import com.mygdx.auber.entities.Powerup;

public class PowerupModel {
    public Float x, y,goalX,goalY;
    public String ability;
    public double chance;

    public PowerupModel(Float x, Float y, double chance) {
        //This stores the basic structure of a Powerup and what information should be saved
        this.x = x;
        this.y = y;
        this.chance = chance;

    }
}