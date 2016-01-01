package dev.zt.UpliftedVFFV.world;

import java.awt.Graphics;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.tiles.TileSorter;
import dev.zt.UpliftedVFFV.utils.Utils;


//Tentative World class. Unused right now.


public class World {
	
	public WorldManager worldmanager;
	private int width, height;					//size of world 
	private int spawnX, spawnY;					//default start location of player. Only used for testing
	private int numEvents;
	private Tile[][] actualTiles;						//matrix of ints. these correspond to the index of specific tiles in the Tile class
	public String Worldname;					//name that shows up in nameplate upon entering new location. ""=no nameplate
	public int enemyrate, enemynum;
	public static TreeMap<Integer, Integer> enemy;
	
	public World(String path, int id, int floor){
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, Game game){
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(game!=null){
					actualTiles[x][y].render(g, (int)(x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
				}
			}
		}
	}
	
	public void loadWorld(String path, WorldManager worldmanager){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");			
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		numEvents = Utils.parseInt(tokens[4]);
		enemyrate = Utils.parseInt(tokens[6]);
		enemynum = Utils.parseInt(tokens[7]);
		actualTiles = new Tile[width][height];
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				actualTiles[x][y] = Tile.getTile(Utils.parseInt(tokens[(x+y*width)+8]));
			}
		}
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				TileSorter.adjacencyCheck(actualTiles[x][y], worldmanager, x, y);
			}
		}
		
	//enemy encounters are loaded. Each troop consists of a pair of numbers, their id and relative frequency respectively
	//this fills a treemap with these pairs of integers which is checked in the player class when moving
		
		for(int i=0; i<enemynum; i++){
			enemy.put(Utils.parseInt(tokens[height*width+8+3*numEvents+2*i]),Utils.parseInt(tokens[(height*width)+9+3*numEvents+2*i]));
		}		
	}
	
	public TreeMap<Integer, Integer> getEnemies(){
		return enemy;
	}

	public String getName(){
		return this.Worldname;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}
	
}
