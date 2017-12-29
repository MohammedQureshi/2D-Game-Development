package com.mohammed.game.level.tile;

import com.mohammed.game.graphics.Screen;
import com.mohammed.game.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
