package de.tomgrill.gdxtesting.tests;

import static org.junit.Assert.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.mygdx.auber.entities.CrewMembers;
import org.mockito.Mock;

@RunWith(GdxTestRunner.class)
public class CrewMembersTest {
    @Mock
    CrewMembers crew;

    @Test
    public void createCrewTest() {
        crew.createCrewSprites();
        Sprite sprite1 = crew.selectSprite(0.1);//selecting sprites depending on chance values
        Sprite sprite2 = crew.selectSprite(1.5);
        Sprite sprite3 = crew.selectSprite(10);
        Sprite sprite4 = crew.selectSprite(15);

        assertEquals(4, crew.crewSprites.size);//checking that exactly four sprites have been added by createCrewSprites()

        assertEquals(crew.crewSprites.get(3),sprite1);//checking that the right sprite has been selected by selectSprite()
        assertEquals(crew.crewSprites.get(2),sprite2);
        assertEquals(crew.crewSprites.get(1),sprite3);
        assertEquals(crew.crewSprites.get(0),sprite4);
    }

}