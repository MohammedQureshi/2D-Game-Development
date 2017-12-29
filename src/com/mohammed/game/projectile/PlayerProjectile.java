package com.mohammed.game.projectile;

import com.mohammed.game.entity.Spawner.ParticleSpawner;
import com.mohammed.game.graphics.Screen;
import com.mohammed.game.graphics.Sprite;

public class PlayerProjectile extends Projectile {

	public static final int FIRE_RATE = 15; // Higher is slower.

	public PlayerProjectile(double x, double y, double dir) {
		super(x, y, dir);
		range = 100;
		speed = 2;
		damage = 2;
		sprite = Sprite.projectile_player;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tilecollision((int) (x + nx), (int) (y + ny), 7, 4, 4)) {
			level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		// if(!level.tilecollision(x, y, nx, ny, 7))
		if (distance() > range)
			remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y)
				* (yOrigin - y)));
		return dist;

	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 7, (int) y - 3, this);
	}

}