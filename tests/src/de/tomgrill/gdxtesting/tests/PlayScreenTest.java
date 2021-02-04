package de.tomgrill.gdxtesting.tests;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;
import com.mygdx.auber.Screens.PlayScreen;
import static org.mockito.Mockito.when;
import com.mygdx.auber.Scenes.Hud;
import com.mygdx.auber.entities.Player;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.powermock.reflect.Whitebox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(GdxTestRunner.class)
public class PlayScreenTest {
    @Mock
    Array<TiledMapTileLayer> playerCollisionLayers;

    @Test
    public void gameOverHealthTest(){
        PlayScreen screen = Mockito.mock(PlayScreen.class); //mock PlayScreen instance
        screen.player = new Player(new Sprite(new Texture("AuberStand.png")), playerCollisionLayers, false);
        //set the 'player' field
        screen.player.takeDamage(200); // make players health <0
        when(screen.gameOver()).thenCallRealMethod();
        assertTrue(screen.gameOver()); //check that gameOver() returns true
    }
    @Test
    public void gameOverNPCTest(){
        PlayScreen screen = Mockito.mock(PlayScreen.class);
        screen.player = new Player(new Sprite(new Texture("AuberStand.png")), playerCollisionLayers, false);
        Hud hud = Mockito.mock(Hud.class); // create a Hud instnce
        hud.CrewmateCount = 5;
        screen.maxIncorrectArrests = 4; // set maxIncorrectArrests < CrewmateCount

        Whitebox.setInternalState(screen, "hud", hud); // inject the previously created Hud into the private field of the mocked PlayScreen
        when(screen.gameOver()).thenCallRealMethod();

        assertTrue(screen.gameOver());
    }
    @Test
    public void gameOverDestroyedSysTest(){
        PlayScreen screen = Mockito.mock(PlayScreen.class);
        screen.player = new Player(new Sprite(new Texture("AuberStand.png")), playerCollisionLayers, false);
        Hud hud = Mockito.mock(Hud.class);
        hud.CrewmateCount = 1;
        screen.maxIncorrectArrests = 4;//set maxIncorrectArrests > CrewmateCount
        Whitebox.setInternalState(screen, "hud", hud);
        when(screen.gameOver()).thenCallRealMethod();
        assertFalse(screen.gameOver());// KeySystemManager.destroyedKeySystemsCount() of the mocked PlayScreen is 0
    }

    @Test
    public void gameWinTest(){
        PlayScreen screen = Mockito.mock(PlayScreen.class);
        when(screen.gameWin()).thenCallRealMethod();
        assertTrue(screen.gameWin()); //infiltrator list of the mocked PlayScreen is empty
    }

}