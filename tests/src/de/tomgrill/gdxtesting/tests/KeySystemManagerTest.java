package de.tomgrill.gdxtesting.tests;

import com.mygdx.auber.entities.KeySystem;
import com.mygdx.auber.entities.KeySystemManager;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class KeySystemManagerTest {
    @Mock
    KeySystemManager manager;

    @Test
    public void beingDestroyedKeySystemsCountTest(){
        KeySystem keySys1 = Mockito.mock(KeySystem.class);//mocking keySystems
        when(keySys1.isBeingDestroyed()).thenReturn(true);//stubbing isBeingDestroyed() method for an instance of keySystem to return true
        KeySystem keySys2 = Mockito.mock(KeySystem.class);
        when(keySys2.isBeingDestroyed()).thenReturn(true);
        KeySystem keySys3 = Mockito.mock(KeySystem.class);
        when(keySys3.isBeingDestroyed()).thenReturn(false);//stubbing isBeingDestroyed() to return false

        manager.keySystems.add(keySys1);//adding mocked KeySystem instances to a mocked KeySystemManager
        manager.keySystems.add(keySys2);
        manager.keySystems.add(keySys3);

        assertEquals(2,manager.beingDestroyedKeySystemsCount());//checking that only two systems are being destroyed
    }
    @Test
    public void DestroyedKeySystemsCountTest(){
        KeySystem keySys4 = Mockito.mock(KeySystem.class);
        when(keySys4.isDestroyed()).thenReturn(true);//stubbing isDestroyed() method to return true
        KeySystem keySys5 = Mockito.mock(KeySystem.class);
        when(keySys5.isDestroyed()).thenReturn(true);
        KeySystem keySys6 = Mockito.mock(KeySystem.class);
        when(keySys6.isDestroyed()).thenReturn(false);

        manager.keySystems.add(keySys4);
        manager.keySystems.add(keySys5);
        manager.keySystems.add(keySys6);

        assertEquals(2,manager.destroyedKeySystemsCount());//checking that only two systems are destroyed
    }



}