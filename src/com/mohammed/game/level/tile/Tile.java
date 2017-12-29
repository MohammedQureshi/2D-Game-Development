package com.mohammed.game.level.tile;

import com.mohammed.game.graphics.*;
import com.mohammed.game.level.tile.spawn_level.SpawnBottomBridgeTile;
import com.mohammed.game.level.tile.spawn_level.SpawnBridgeTile;
import com.mohammed.game.level.tile.spawn_level.SpawnDirtTile;
import com.mohammed.game.level.tile.spawn_level.SpawnDoorBottom;
import com.mohammed.game.level.tile.spawn_level.SpawnDoorTop;
import com.mohammed.game.level.tile.spawn_level.SpawnGlassTile;
import com.mohammed.game.level.tile.spawn_level.SpawnGrassTile;
import com.mohammed.game.level.tile.spawn_level.SpawnLavaTile;
import com.mohammed.game.level.tile.spawn_level.SpawnOilTile;
import com.mohammed.game.level.tile.spawn_level.SpawnPlasticTile;
import com.mohammed.game.level.tile.spawn_level.SpawnStoneBrickTile;
import com.mohammed.game.level.tile.spawn_level.SpawnStoneTile;
import com.mohammed.game.level.tile.spawn_level.SpawnTopBridgeTile;
import com.mohammed.game.level.tile.spawn_level.SpawnWaterTile;
import com.mohammed.game.level.tile.spawn_level.SpawnWoodTile;
import com.mohammed.game.level.tile.spawn_level.SpawnxDoor;
import com.mohammed.game.level.tile.spawn_level.SpawnyDoor;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_lava = new SpawnLavaTile(Sprite.spawn_lava);
	public static Tile spawn_dirt = new SpawnDirtTile(Sprite.spawn_dirt);
	public static Tile spawn_platic = new SpawnPlasticTile(Sprite.spawn_plastic);
	public static Tile spawn_stone = new SpawnStoneTile(Sprite.spawn_stone);
	public static Tile spawn_glass = new SpawnGlassTile(Sprite.spawn_glass);
	public static Tile spawn_stonebrick = new SpawnStoneBrickTile(Sprite.spawn_stonebrick);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wood = new SpawnWoodTile(Sprite.spawn_wood);
	public static Tile spawn_bridge = new SpawnBridgeTile(Sprite.spawn_bridge);
	public static Tile spawn_bridge_top = new SpawnTopBridgeTile(Sprite.spawn_bridge_top);
	public static Tile spawn_bridge_bottom = new SpawnBottomBridgeTile(Sprite.spawn_bridge_bottom);
	public static Tile spawn_xDoor = new SpawnxDoor(Sprite.spawn_xDoor);
	public static Tile spawn_yDoor = new SpawnyDoor(Sprite.spawn_yDoor);
	public static Tile spawn_oil = new SpawnOilTile(Sprite.spawn_oil);
	public static Tile spawn_DoorTop = new SpawnDoorTop(Sprite.spawn_DoorTop);
	public static Tile spawn_DoorBottom = new SpawnDoorBottom(Sprite.spawn_DoorBottom);
	public static Tile spawn_RoofLeft = new SpawnDoorBottom(Sprite.spawn_RoofLeft);
	public static Tile spawn_RoofRight = new SpawnDoorBottom(Sprite.spawn_RoofRight);
	
	public static final int col_spawn_RoofLeft = 0xff3F3F3F;
	public static final int col_spawn_RoofRight = 0xffA07878;
	public static final int col_spawn_DoorTop = 0xffFF5900;
	public static final int col_spawn_DoorBottom = 0xffFFC300;
	public static final int col_spawn_grass = 0xff2AFF00;
	public static final int col_spawn_lava = 0xffFF6E00;
	public static final int col_spawn_dirt = 0xff7F3300;
	public static final int col_spawn_plastic = 0xff0026FF;
	public static final int col_spawn_stone = 0xff404040;
	public static final int col_spawn_glass = 0; //unused
	public static final int col_spawn_stonebrick = 0xff808080;
	public static final int col_spawn_water = 0xff00FFFF;
	public static final int col_spawn_wood = 0xffC64F00;
	public static final int col_spawn_bridge = 0xffD17840;
	public static final int col_spawn_bridge_top = 0xffCE9A79;
	public static final int col_spawn_bridge_bottom = 0xffFFBA6B;
	public static final int col_spawn_xDoor = 0xffC08559;
	public static final int col_spawn_yDoor = 0xffFFA14F;
	public static final int col_spawn_oil = 0xff2D2D2D;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
}
