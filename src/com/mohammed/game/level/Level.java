package com.mohammed.game.level;

import java.util.ArrayList;
import java.util.List;

import com.mohammed.game.entity.Entity;
import com.mohammed.game.entity.Particles.Particle;
import com.mohammed.game.entity.mob.Player;
import com.mohammed.game.graphics.Screen;
import com.mohammed.game.level.tile.Tile;
import com.mohammed.game.projectile.Projectile;

public class Level {

	/**
	 * �Mohammed Qureshi 2014-2015
	 */

	protected int Width, Height;
	protected int[] tilesInt;
	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/levels/WorldMap.png");

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	private List<Player> players = new ArrayList<Player>();
	
	
	public Level(int Width, int Height) {
		this.Width = Width;
		this.Height = Height;
		tilesInt = new int[Width * Height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
	}

	protected void generateLevel() {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++) {
				getTile(x, y);
			}
		}
	}

	protected void loadLevel(String path) {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).update();
		}
		remove();
	}
	
	private void remove(){
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for (int i = 0; i < particles.size(); i++) {
			if(particles.get(i).isRemoved()) particles.remove(i);
		}
        for (int i = 0; i < players.size(); i++) {
			if(players.get(i).isRemoved()) players.remove(i);
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	@SuppressWarnings("unused")
	private void time() {

		}

	public boolean tilecollision(int x, int y, int size, int xOffset, int yOffset) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size + xOffset) >> 4;
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if (getTile(xt, yt).solid())
				solid = true;
		}
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.Width + 16) >> 4;

		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.Height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(screen);
		}

	}

	public void add(Entity e) {
		e.init(this);
		if(e instanceof Particle){
			particles.add((Particle) e);
		}else if(e instanceof Projectile){
			projectiles.add((Projectile)e);
		}else if( e instanceof Player){
			players.add((Player) e);
		}
		else{
			entities.add(e);	
		}
	}
	
	public List<Player> getPlayer(){
		return players;
	}
	
	public Player getPlayerAt(int index){
		return players.get(index);
	}
	
	public Player getClientPlayer(){
		return players.get(0);
	}
	
	public List<Entity>getEntities(Entity e, int radius){
		List<Entity> result = new ArrayList<Entity>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i = 0; i < entities.size(); i++){
			Entity entity = entities.get(i);
			int x = (int)entity.getX();
			int y = (int)entity.getY();
			
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx)+(dy * dy));
			
			if(distance <= radius) result.add(entity);
		}
		return result;
	}
	
	public List<Player> getPlayers(Entity e, int radius){
		List<Player> result = new ArrayList<Player>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i = 0; i < players.size(); i++){
			Player player = players.get(i);
			int x = (int)player.getX();
			int y = (int)player.getY();		
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx)+(dy * dy));		
			if(distance <= radius) result.add(player);
			}
		return result;
		}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= Width || y >= Height)
			return Tile.spawn_water;
		if (tiles[x + y * Width] == Tile.col_spawn_dirt)
			return Tile.spawn_dirt;
		if (tiles[x + y * Width] == Tile.col_spawn_grass)
			return Tile.spawn_grass;
		if (tiles[x + y * Width] == Tile.col_spawn_lava)
			return Tile.spawn_lava;
		if (tiles[x + y * Width] == Tile.col_spawn_plastic)
			return Tile.spawn_platic;
		if (tiles[x + y * Width] == Tile.col_spawn_stone)
			return Tile.spawn_stone;
		if (tiles[x + y * Width] == Tile.col_spawn_stonebrick)
			return Tile.spawn_stonebrick;
		if (tiles[x + y * Width] == Tile.col_spawn_wood)
			return Tile.spawn_wood;
		if (tiles[x + y * Width] == Tile.col_spawn_water)
			return Tile.spawn_water;
		if (tiles[x + y * Width] == Tile.col_spawn_bridge)
			return Tile.spawn_bridge;
		if (tiles[x + y * Width] == Tile.col_spawn_bridge_top)
			return Tile.spawn_bridge_top;
		if (tiles[x + y * Width] == Tile.col_spawn_bridge_bottom)
			return Tile.spawn_bridge_bottom;
		if (tiles[x + y * Width] == Tile.col_spawn_xDoor)
			return Tile.spawn_xDoor;
		if (tiles[x + y * Width] == Tile.col_spawn_yDoor)
			return Tile.spawn_yDoor;
		if(tiles[x + y * Width] == Tile.col_spawn_oil)
			return Tile.spawn_oil;
		if(tiles[x + y * Width] == Tile.col_spawn_DoorTop)
			return Tile.spawn_DoorTop;
		if(tiles[x + y * Width] == Tile.col_spawn_DoorBottom)
			return Tile.spawn_DoorBottom;
		if(tiles[x + y * Width] == Tile.col_spawn_RoofLeft)
			return Tile.spawn_RoofLeft;
		if(tiles[x + y * Width] == Tile.col_spawn_RoofRight)
			return Tile.spawn_RoofRight;

		return Tile.spawn_water;
	}
}
