package com.mygdx.auber.ClassModels;

import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.Screens.PlayScreen;
import com.mygdx.auber.entities.CrewMembers;
import com.mygdx.auber.entities.NPCCreator;

import java.util.ArrayList;
import java.util.List;


public class NPCInfo {
    public List<CrewModel> data = new ArrayList<>();
    public int npcNumber;
    public NPCInfo() {
        //this runs through every NPC and saves their data to an array

        for (CrewMembers crew: NPCCreator.crew){
            data.add(new CrewModel(crew.getX(),crew.getY(),crew.currentImage,crew.currentGoal.x,crew.currentGoal.y,false));
            //,crew.currentGoal.x,crew.currentGoal.y
        }
        this.npcNumber = PlayScreen.numberOfCrew;
    }
}


