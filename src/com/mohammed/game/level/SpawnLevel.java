package com.mohammed.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mohammed.game.entity.mob.Chaser;
import com.mohammed.game.entity.mob.Dummy;

public class SpawnLevel extends Level{
	
	public SpawnLevel(String path){
		super(path);
		
	}
	
	protected void loadLevel(String path) {
		try{
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = Width = image.getWidth();
			int h = Height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Exception! Could not load level file");
		}
		
		//Change 1 To Change How Many Spawn.
		for(int i = 0; i < 1; i++){
		   add(new Chaser(18,30));
		}
		for(int i = 0; i < 5; i++){
			   add(new Dummy(18,30));
			}
			
	}
	
	//Grass = 0x00FF04
	//Flower = 0xFFDD00
	//Rock = 0x808080
	protected void generateLevel(){
		for(int y = 0; y < 64; y++){
			for(int x = 0; x < 64; x++){
				getTile(x, y);
			}
		}
	}
	
}
