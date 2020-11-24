package com.mygdx.auber.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.auber.Auber;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 144;
		config.width = 1920;
		config.height = 1080;
		config.fullscreen = true;
		new LwjglApplication(new Auber(), config);
	}
}
