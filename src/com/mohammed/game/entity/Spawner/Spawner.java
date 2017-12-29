package com.mohammed.game.entity.Spawner;

import com.mohammed.game.entity.Entity;
import com.mohammed.game.level.Level;

public abstract class Spawner extends Entity{
	
	public enum Type {
		MOB, PARTICLE;
	}
	
	@SuppressWarnings("unused")
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level){
		init(level);
		this.x = x;
		this.y = x;
		this.type = type;
	}
}
