package dev.dacoder.tester;

import dev.dacoder.models.TexturedModel;
import org.lwjgl.opengl.Display;
import dev.dacoder.engine.DisplayManager;
import dev.dacoder.engine.Loader;
import dev.dacoder.models.RawModel;
import dev.dacoder.engine.Renderer;
import dev.dacoder.shaders.StaticShader;
import dev.dacoder.textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();

		Loader loader = new Loader();
		Renderer renderer = new Renderer();

		StaticShader shader = new StaticShader();

		float[] vertices = {
			-0.5f,  0.5f, 0.0f, // v0
			-0.5f, -0.5f, 0.0f, // v1
			 0.5f, -0.5f, 0.0f, // v2
			 0.5f,  0.5f, 0.0f  // v3
		};

		int[] indices = {
			0, 1, 3, // top left triangle     (v0, v1, v3)
			3, 1, 2  // bottom right triangle (v3, v1, v2)
		};

		float[] textureCoords = {
			0.0f, 0.0f, // v0
			0.0f, 1.0f, // v1
			1.0f, 1.0f, // v2
			1.0f, 0.0f, // v3
		};

		RawModel model = loader.loadToVao(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("image"));

		TexturedModel texturedModel = new TexturedModel(model, texture);

		while (!Display.isCloseRequested()) {
			renderer.prepare();

			shader.start();
			renderer.render(texturedModel);
			shader.stop();

			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
