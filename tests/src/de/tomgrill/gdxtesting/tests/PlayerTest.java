package de.tomgrill.gdxtesting.tests;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.Screens.PlayScreen;
import com.mygdx.auber.entities.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.badlogic.gdx.math.Vector2;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import de.tomgrill.gdxtesting.GdxTestRunner;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;


@RunWith(GdxTestRunner.class)
public class PlayerTest{

    @Mock
    Array<TiledMapTileLayer> playerCollisionLayers;

    Player player = new Player(new Sprite(new Texture("AuberStand.png")), playerCollisionLayers, false);

    @Test
    public void testTeleport(){

        Array<Vector2> tels = new Array<Vector2>();
        tels.add(new Vector2(1712,2448)); //adding coordinates of teleporters
        tels.add(new Vector2(1712,3632));

        player.setPosition(1712, 3632); //'placeing' the player near on of the teleporters

        player.teleporters = tels; //set teleporters
        player.teleport(); // teleporting player

        assertEquals(2448, player.getY(), 0.1);// player should've been teleported to the second teleporter
    }

    @Test
    public void healByAmountTest(){

        player.health = 20f; //assume that player is injured
        player.heal(30); //heal the player by a specific amount

        assertEquals(50f, player.health, 0.1);
    }

    @Test
    public void healByAmountTest2(){

        player.health = 80f; //assume that player is injured
        player.heal(30); //heal the player by a specific amount, so that the resulting health > 100

        assertEquals(100f, player.health, 0.1);
    }

    @Test
    public void fullHealTest(){

        player.health = 20f; //assume that player is injured
        player.heal(); //fully restore player's health

        assertEquals(100f, player.health, 0.1);
    }
    @Test
    public void damageTest(){
        PlayScreen screen = Mockito.mock(PlayScreen.class); //mock PlayScreen
        screen.player = player;
        screen.player.activeAbility = "None"; //setting player's ability to None
        screen.player.takeDamage(20); //damaging player

        assertEquals(80f, screen.player.health, 0.1);
    }

}