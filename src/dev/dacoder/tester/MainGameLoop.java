package dev.dacoder.tester;

import dev.dacoder.entities.Entity;
import dev.dacoder.models.TexturedModel;
import org.lwjgl.opengl.Display;
import dev.dacoder.engine.DisplayManager;
import dev.dacoder.engine.Loader;
import dev.dacoder.models.RawModel;
import dev.dacoder.engine.Renderer;
import dev.dacoder.shaders.StaticShader;
import dev.dacoder.textures.ModelTexture;
import org.lwjgl.util.vector.Vector3f;

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();

		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		float[] vertices = {
			-0.5f, 0.5f, 0.0f,  // v0
			-0.5f, -0.5f, 0.0f, // v1
			0.5f, -0.5f, 0.0f,  // v2
			0.5f, 0.5f, 0.0f    // v3
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

		Vector3f position = new Vector3f(0, 0, -1);
		Vector3f rotation = new Vector3f(0, 0, 0);
		Entity entity = new Entity(texturedModel, position, rotation, 1);

		while (!Display.isCloseRequested()) {
			renderer.prepare();

			shader.start();
			renderer.render(entity, shader);
			shader.stop();

			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
