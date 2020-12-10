package com.mygdx.auber;

import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.entities.CrewMembers;
import com.mygdx.auber.entities.Infiltrator;
import com.mygdx.auber.entities.NPCCreator;

import java.util.List;


public class NPCInfo {
    public List<CrewMembers> crew;
    public List<Infiltrator> infiltrators;

    public NPCInfo() {
        this.crew = NPCCreator.crew;
        this.infiltrators = NPCCreator.infiltrators;


    }
}
