package dev.dacoder.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {

	private static final int WIDTH = 1080;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 120;

	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3, 2)
			.withForwardCompatible(true)
			.withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Simple 3D Engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}

	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}

	public static void closeDisplay() {
		Display.destroy();
		System.exit(0);
	}

}
