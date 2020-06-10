package dev.dacoder.entities;

import dev.dacoder.models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;

public class Entity {

	private TexturedModel model;
	private Vector3f position;
	private Vector3f rotation;
	private float scale;

	public Entity(TexturedModel model, float posX, float posY, float posZ, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.scale = scale;
		this.position = new Vector3f(posX, posY, posZ);
		this.rotation = new Vector3f(rotX, rotY, rotZ);
	}

	public Entity(TexturedModel model, Vector3f position, Vector3f rotation, float scale) {
		this.model = model;
		this.scale = scale;
		this.position = position;
		this.rotation = rotation;
	}

	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}

	public void increasePosition(Vector3f position) {
		Vector3f.add(position, this.position, this.position);
	}

	public void increaseRotation(float dx, float dy, float dz) {
		this.rotation.x += dx;
		this.rotation.y += dy;
		this.rotation.z += dz;
	}

	public void increaseRotation(Vector3f rotation) {
		Vector3f.add(rotation, this.rotation, this.rotation);
	}

	public TexturedModel getModel() {
		return model;
	}

	public void setModel(TexturedModel model) {
		this.model = model;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
}
