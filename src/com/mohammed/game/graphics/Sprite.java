package com.mohammed.game.graphics;

public class Sprite {

	/**
	 * ©Mohammed Qureshi 2014-2015
	 */

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	protected SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x058DEB);

	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);

	// Spawn Level Sprites Here:
	public static Sprite spawn_grass = new Sprite(16, 1, 0,
			SpriteSheet.spawn_level);
	public static Sprite spawn_dirt = new Sprite(16, 2, 0,
			SpriteSheet.spawn_level);

	public static Sprite spawn_plastic = new Sprite(16, 1, 2,
			SpriteSheet.spawn_level);
	public static Sprite spawn_stone = new Sprite(16, 1, 1,
			SpriteSheet.spawn_level);
	public static Sprite spawn_glass = new Sprite(16, 2, 1,
			SpriteSheet.spawn_level);

	public static Sprite spawn_stonebrick = new Sprite(16, 0, 2,
			SpriteSheet.spawn_level);
	public static Sprite spawn_wood = new Sprite(16, 2, 2,
			SpriteSheet.spawn_level);
	
	//Liquid
	public static Sprite spawn_lava = new Sprite(16, 0, 0,
			SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 1, 2,
			SpriteSheet.spawn_level);
	public static Sprite spawn_oil = new Sprite(16, 0, 1, 
			SpriteSheet.spawn_level);
	
	
	//Doors
	public static Sprite spawn_DoorTop = new Sprite(16,0,4, SpriteSheet.spawn_level);
	public static Sprite spawn_DoorBottom = new Sprite(16,0,5, SpriteSheet.spawn_level);
	
	//Roof
	public static Sprite spawn_RoofLeft = new Sprite(16,2,3, SpriteSheet.spawn_level);
	public static Sprite spawn_RoofRight = new Sprite(16,3,3, SpriteSheet.spawn_level);
	
	
	//Bridge Parts
	public static Sprite spawn_bridge = new Sprite(16, 5, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_bridge_top = new Sprite(16, 5, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_bridge_bottom = new Sprite(16, 5, 2, SpriteSheet.spawn_level);
	
	//Fake Doors - Change In Future
	public static Sprite spawn_xDoor = new Sprite(16, 0, 3, SpriteSheet.spawn_level);
	public static Sprite spawn_yDoor = new Sprite(16, 1, 3, SpriteSheet.spawn_level);

	// Projectile Sprites Here:
	public static Sprite projectile_player = new Sprite(16, 0, 0,
			SpriteSheet.projectile_player);

	// Player Sprites Here:
	public static Sprite player_forward = new Sprite(32, 0, 5,
			SpriteSheet.tiles);
	public static Sprite player_backward = new Sprite(32, 2, 5,
			SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);

	public static Sprite player_forward_1 = new Sprite(32, 0, 6,
			SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 0, 7,
			SpriteSheet.tiles);

	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public static Sprite player_backward_1 = new Sprite(32, 2, 6,
			SpriteSheet.tiles);
	public static Sprite player_backward_2 = new Sprite(32, 2, 7,
			SpriteSheet.tiles);
	
	public static Sprite dummy = new Sprite(32, 0, 0, SpriteSheet.dummy_down);
	//Particles
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);
	
	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	private void setColour(int colour) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.WIDTH];
			}
		}
	}

}
