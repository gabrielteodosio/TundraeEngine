package dev.dacoder.engine;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import dev.dacoder.entities.Entity;
import dev.dacoder.models.RawModel;
import dev.dacoder.models.TexturedModel;
import dev.dacoder.shaders.StaticShader;
import dev.dacoder.toolbox.Maths;

public class Renderer {

	private static final float FOV = 70f;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000f;

	private Matrix4f projectionMatrix;

	public Renderer(StaticShader shader) {
		createProjectionMatrix();

		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}

	public void prepare() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.1f, 0.1f, 0.1f, 1f);
	}

	public void render(Entity entity, StaticShader shader) {
		TexturedModel texturedModel = entity.getModel();
		RawModel rawModel = texturedModel.getRawModel();

		GL30.glBindVertexArray(rawModel.getVaoId());

		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);

		Vector3f entityPosition = entity.getPosition();
		Vector3f entityRotation = entity.getRotation();
		Matrix4f transformationMatrix = Maths.createTransformationMatrix(entityPosition, entityRotation.x,
				entityRotation.y, entityRotation.z, entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);

		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getTextureId());
		GL11.glDrawElements(GL11.GL_TRIANGLES, rawModel.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);

		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);

		GL30.glBindVertexArray(0);
	}

	private void createProjectionMatrix() {
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float yScale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float xScale = yScale / aspectRatio;
		float frustumLength = FAR_PLANE / NEAR_PLANE;

		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = xScale;
		projectionMatrix.m11 = yScale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustumLength);
		projectionMatrix.m23 = -1f;
		projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustumLength);
		projectionMatrix.m33 = 0f;
	}
}
