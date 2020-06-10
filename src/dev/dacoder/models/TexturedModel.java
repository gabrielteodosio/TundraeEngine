package dev.dacoder.models;

import dev.dacoder.textures.ModelTexture;

public class TexturedModel {

	private final RawModel rawModel;
	private final ModelTexture texture;

	public TexturedModel(RawModel rawModel, ModelTexture texture) {
		this.rawModel = rawModel;
		this.texture = texture;
	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return texture;
	}
}
