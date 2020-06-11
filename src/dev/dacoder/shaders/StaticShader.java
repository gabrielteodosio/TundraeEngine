package dev.dacoder.shaders;

import org.lwjgl.util.vector.Matrix4f;

import dev.dacoder.entities.Camera;
import dev.dacoder.entities.Light;
import dev.dacoder.toolbox.Maths;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/dev/dacoder/shaders/vertexShader.vert";
	private static final String FRAGMENT_FILE = "src/dev/dacoder/shaders/fragmentShader.frag";

	private int locationTransformationMatrix;

	private int locationProjectionMatrix;
	private int locationViewMatrix;

	private int locationLightPosition;
	private int locationLightColour;

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void getAllUniformLocations() {
		locationTransformationMatrix = super.getUniformLocation("transformationMatrix");

		locationProjectionMatrix = super.getUniformLocation("projectionMatrix");
		locationViewMatrix = super.getUniformLocation("viewMatrix");

		locationLightPosition = super.getUniformLocation("lightPosition");
		locationLightColour = super.getUniformLocation("lightColour");
	}

	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(locationTransformationMatrix, matrix);
	}

	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(locationProjectionMatrix, projection);
	}

	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(locationViewMatrix, viewMatrix);
	}

	public void loadLight(Light light) {
		super.loadVector(locationLightPosition, light.getPosition());
		super.loadVector(locationLightColour, light.getColour());
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");
	}
}
