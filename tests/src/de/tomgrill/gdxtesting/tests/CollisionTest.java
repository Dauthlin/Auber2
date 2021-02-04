package de.tomgrill.gdxtesting.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.mygdx.auber.entities.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

@RunWith(GdxTestRunner.class)
public class CollisionTest {


    @Test
    public void checkForCollisionTest(){
        TiledMapTileLayer layer1 = Mockito.mock(TiledMapTileLayer.class);

        Sprite sprite = Mockito.mock(Sprite.class);
        doReturn(0f).when(sprite).getX();//stubbing getX() and getY() methods of the mocked Sprite instances
        doReturn(0f).when(sprite).getY();
        doNothing().when(sprite).setX(anyFloat());//ignoring setX() and setY() method invocation
        doNothing().when(sprite).setY(anyFloat());

        Collision collision = Mockito.mock(Collision.class);
        doReturn(true).when(collision).collidesLeft(Mockito.any(Sprite.class), Mockito.any(TiledMapTileLayer.class));
        //stubbing collidesLeft(), so that it always returns true

        Vector2 velocity = new Vector2(-1, 0);
        Array<TiledMapTileLayer> layers = new Array<TiledMapTileLayer>();
        layers.add(layer1);//adding mocked TiledMapTileLayer to allow iterating over Array<TiledMapTileLayer>

        when(collision.checkForCollision(sprite, layers, velocity, collision)).thenCallRealMethod();
        Vector2 result = collision.checkForCollision(sprite, layers, velocity, collision);//resulting velocity
        Vector2 actual = new Vector2(0, 0);//intended velocity
        assertEquals(actual, result);
    }
    @Test
    public void checkForCollisionTest2(){
        TiledMapTileLayer layer2 = Mockito.mock(TiledMapTileLayer.class);

        Sprite sprite = Mockito.mock(Sprite.class);
        doReturn(0f).when(sprite).getX();//stubbing getX() and getY() methods of the mocked Sprite instances
        doReturn(0f).when(sprite).getY();
        doNothing().when(sprite).setX(anyFloat());//ignoring setX() and setY() method invocation
        doNothing().when(sprite).setY(anyFloat());

        Collision collision = Mockito.mock(Collision.class);
        doReturn(true).when(collision).collidesBottom(Mockito.any(Sprite.class), Mockito.any(TiledMapTileLayer.class));
        //stubbing collidesBottom(), so that it always returns true

        Vector2 velocity = new Vector2(0, -1);
        Array<TiledMapTileLayer> layers = new Array<TiledMapTileLayer>();
        layers.add(layer2);//adding mocked TiledMapTileLayer to allow iterating over Array<TiledMapTileLayer>

        when(collision.checkForCollision(sprite, layers, velocity, collision)).thenCallRealMethod();
        Vector2 result = collision.checkForCollision(sprite, layers, velocity, collision);//resulting velocity
        Vector2 actual = new Vector2(0, 0);//intended velocity
        assertEquals(actual, result);
    }

}