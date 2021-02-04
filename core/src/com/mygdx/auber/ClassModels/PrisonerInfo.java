package com.mygdx.auber.ClassModels;

import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.entities.Prisoners;

import java.util.ArrayList;
import java.util.List;

public class PrisonerInfo {
    public List<PrisonerModel> data = new ArrayList<>();
    public int prisNumber;

    public PrisonerInfo() {
        //this runs through every prisoner and saves their data to an array
        for (int i = 0; i < Prisoners.prisonerSide.size(); i++) {
            data.add(new PrisonerModel(Prisoners.prisonerSide.get(i),Prisoners.prisonerChance.get(i)));
        }
        this.prisNumber = Prisoners.prisonerSide.size();
    }
}
