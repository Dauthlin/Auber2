package com.mygdx.auber.Models;

import com.mygdx.auber.Screens.PlayScreen;
import com.mygdx.auber.entities.Player;

public class PlayerInfo {
    public float x;
    public float y;
    public float health;
    public int numberOfInfiltrators;
    public int numberOfCrew;
    public int maxIncorrectArrests;

    public PlayerInfo() {
        //as there is only one player a info class is not required
        //this collects data about the player that needs to be saved
        this.x = Player.x;
        this.y = Player.y;
        this.health= Player.health;
        this.numberOfInfiltrators = PlayScreen.numberOfInfiltrators;
        this.numberOfCrew = PlayScreen.numberOfCrew;
        this.maxIncorrectArrests = PlayScreen.maxIncorrectArrests;
    }
}
