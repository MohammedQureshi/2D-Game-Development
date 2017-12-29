package com.mohammed.game.level;

import java.util.Random;

public class RandomLevel extends Level{

	private static final Random random = new Random();
	
	public RandomLevel(int Width, int Height) {
		super(Width, Height);
		
	}
	
	protected void generateLevel(){
		for(int y = 0; y< Height; y++){
			for(int x = 0; x < Width; x++){
				tilesInt[x + y * Width] = random.nextInt(4);
			}
		}
	}

}
