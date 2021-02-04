package com.mygdx.auber.LoadingSaving;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.google.gson.Gson;
import com.mygdx.auber.Auber;
import com.mygdx.auber.ClassModels.PlayerInfo;
import com.mygdx.auber.Screens.PlayScreen;
import com.mygdx.auber.entities.Player;

import java.util.Map;

public class LoadingGame {
    //this class is run if the game needs to be loaded and tells the game that it needs to be loading data when starting up the game


    public void loadGame(Auber game){
        if (if_exists("Saved Game")){
            //only runs if a save actually exists
            Gson gson = new Gson();
            String playerSave = Gdx.app.getPreferences("Saved Game").getString("playerInfo");
            PlayerInfo playerInfo = gson.fromJson(playerSave, PlayerInfo.class);
            //sets the starting game setting to be correct on creation
            game.setScreen(new PlayScreen(game, false,playerInfo.numberOfInfiltrators,playerInfo.numberOfCrew,playerInfo.maxIncorrectArrests, true));

        }

    }
    public boolean if_exists(String prefname)
    //code for checking if a preference exists
    //https://badlogicgames.com/forum/viewtopic.php?f=11&t=21008
    {
        Preferences tmprefs = Gdx.app.getPreferences ( prefname );
        Map tmpmap = tmprefs.get();
        if ( tmpmap.isEmpty() == true )
            return false;
        else
            return true;
    }

}
