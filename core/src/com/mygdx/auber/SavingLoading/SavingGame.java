package com.mygdx.auber.SavingLoading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.google.gson.Gson;
import com.mygdx.auber.Models.*;
import com.mygdx.auber.entities.Player;
import com.mygdx.auber.entities.Powerup;

public class SavingGame {



    public void playerSave(){
        //runs through all the different classes that need to be saved and saves the important information as a preference
        Preferences prefs = Gdx.app.getPreferences("Saved Game");
        Gson gson = new Gson();

        //saves player info
        PlayerInfo playerInfo = new PlayerInfo();
        String player = gson.toJson(playerInfo);
        prefs.putString("playerInfo",player);

        //saves NPC info
        NPCInfo npcInfo = new NPCInfo();
        String npc = gson.toJson(npcInfo);
        prefs.putString("npcInfo",npc);

        //saves infiltrator info
        INFInfo infInfo = new INFInfo();
        String inf = gson.toJson(infInfo);
        prefs.putString("infInfo",inf);

        //saves powerup info
        PowerupInfo powerupInfo = new PowerupInfo();
        String pwr = gson.toJson(powerupInfo);
        prefs.putString("powerupInfo",pwr);

        //saves prisoner info
        PrisonerInfo prisInfo = new PrisonerInfo();
        String pris = gson.toJson(prisInfo);
        prefs.putString("prisInfo",pris);
        prefs.flush();





        //System.out.println(pwr);
    }

}
