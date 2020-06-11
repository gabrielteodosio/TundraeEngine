package dev.dacoder.models;

import dev.dacoder.engine.Loader;

public class ModelGenerator {

	public static RawModel generateCube(Loader loader) {
		return null;
//		float[] vertices = {
//			-0.5f,0.5f,-0.5f,
//			-0.5f,-0.5f,-0.5f,
//			0.5f,-0.5f,-0.5f,
//			0.5f,0.5f,-0.5f,
//
//			-0.5f,0.5f,0.5f,
//			-0.5f,-0.5f,0.5f,
//			0.5f,-0.5f,0.5f,
//			0.5f,0.5f,0.5f,
//
//			0.5f,0.5f,-0.5f,
//			0.5f,-0.5f,-0.5f,
//			0.5f,-0.5f,0.5f,
//			0.5f,0.5f,0.5f,
//
//			-0.5f,0.5f,-0.5f,
//			-0.5f,-0.5f,-0.5f,
//			-0.5f,-0.5f,0.5f,
//			-0.5f,0.5f,0.5f,
//
//			-0.5f,0.5f,0.5f,
//			-0.5f,0.5f,-0.5f,
//			0.5f,0.5f,-0.5f,
//			0.5f,0.5f,0.5f,
//
//			-0.5f,-0.5f,0.5f,
//			-0.5f,-0.5f,-0.5f,
//			0.5f,-0.5f,-0.5f,
//			0.5f,-0.5f,0.5f
//		};
//
//		float[] textureCoords = {
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0,
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0,
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0,
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0,
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0,
//			0, 0,
//			0, 1,
//			1, 1,
//			1, 0
//		};
//
//		int[] indices = {
//			0,  1,  3,
//			3,  1,  2,
//			4,  5,  7,
//			7,  5,  6,
//			8,  9,  11,
//			11, 9,  10,
//			12, 13, 15,
//			15, 13, 14,
//			16, 17, 19,
//			19, 17, 18,
//			20, 21, 23,
//			23, 21, 22
//		};
//
//		return loader.loadToVao(vertices, textureCoords, indices);
	}

	public static RawModel generatePlane() {
		return null;
//		float[] vertices = {
//			-0.5f, 0.5f, 0.0f,  // v0
//			-0.5f, -0.5f, 0.0f, // v1
//			0.5f, -0.5f, 0.0f,  // v2
//			0.5f, 0.5f, 0.0f    // v3
//		};
//
//		int[] indices = {
//			0, 1, 3, // top left triangle     (v0, v1, v3)
//			3, 1, 2  // bottom right triangle (v3, v1, v2)
//		};
//
//		float[] textureCoords = {
//			0.0f, 0.0f, // v0
//			0.0f, 1.0f, // v1
//			1.0f, 1.0f, // v2
//			1.0f, 0.0f, // v3
//		};
//
//		return loader.loadToVao(vertices, textureCoords, indices);
	}
}
