package com.mygdx.auber.ClassModels;

public class PrisonerModel {
    public double chance;
    public  boolean side;

    public PrisonerModel(Boolean side, Double chance){
        //This stores the basic structure of a Prisoner and what information should be saved
        this.side = side;
        this.chance = chance;

    }
}
