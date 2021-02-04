package de.tomgrill.gdxtesting.tests;

import static org.junit.Assert.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.auber.entities.Infiltrator;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

@RunWith(GdxTestRunner.class)
public class InfiltratorTest {
    @Mock Infiltrator infiltrators;


    @Test
    public void createInfiltratorsTest(){

        infiltrators.createInfiltratorSprites();
        Sprite sprite1 = infiltrators.selectSprite(1.5);//selecting infiltrator sprites based on chance value
        Sprite sprite2 = infiltrators.selectSprite(10);
        Sprite sprite3 = infiltrators.selectSprite(15);

        assertEquals(3,infiltrators.easySprites.size);//checking that exactly three sprites were added by createInfiltratorSprites()

        assertEquals(infiltrators.easySprites.get(2),sprite1);// checking that the right sprite has been selected
        assertEquals(infiltrators.easySprites.get(1),sprite2);
        assertEquals(infiltrators.easySprites.get(0),sprite3);
    }

}