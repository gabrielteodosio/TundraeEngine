package dev.dacoder.tester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import dev.dacoder.engine.DisplayManager;
import dev.dacoder.engine.Loader;
import dev.dacoder.engine.OBJLoader;
import dev.dacoder.engine.Renderer;
import dev.dacoder.entities.Camera;
import dev.dacoder.entities.Entity;
import dev.dacoder.entities.Light;
import dev.dacoder.models.RawModel;
import dev.dacoder.models.TexturedModel;
import dev.dacoder.shaders.StaticShader;
import dev.dacoder.textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();

		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		RawModel model = OBJLoader.loadObjModel("robot", loader);
		ModelTexture texture = new ModelTexture(loader.loadTexture("steel"));

		TexturedModel texturedModel = new TexturedModel(model, texture);

		Vector3f position = new Vector3f(0, 0, -10);
		Vector3f rotation = new Vector3f(0, 0, 0);
		Entity entity = new Entity(texturedModel, position, rotation, 1);

		Camera camera = new Camera();
		Light light = new Light(camera.getPosition(), new Vector3f(1, 1, 1));

		while (!Display.isCloseRequested()) {
			entity.increaseRotation(0, 0.1f, 0);

			renderer.prepare();
			camera.move();

			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();

			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
