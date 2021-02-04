package com.mygdx.auber.ClassModels;

import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.Screens.PlayScreen;
import com.mygdx.auber.entities.CrewMembers;
import com.mygdx.auber.entities.GeneratePowerups;
import com.mygdx.auber.entities.NPCCreator;
import com.mygdx.auber.entities.Powerup;

import java.util.ArrayList;
import java.util.List;


public class PowerupInfo {
    public List<PowerupModel> data = new ArrayList<>();
    public int powerupNumber;
    public PowerupInfo() {
        //this runs through every Powerup and saves their data to an array
        for (Powerup powerup: GeneratePowerups.Powerups){
            data.add(new PowerupModel(powerup.getX(),powerup.getY(),powerup.getChance()));
        }
        this.powerupNumber = PlayScreen.numberOfPowerups;
    }
}


