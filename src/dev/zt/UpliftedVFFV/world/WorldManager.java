package dev.zt.UpliftedVFFV.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.tiles.Black;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.tiles.TileSorter;
import dev.zt.UpliftedVFFV.utils.Utils;

public class WorldManager implements Serializable{
	
	private static final long serialVersionUID = 8L;
	
	private Game game;
	private int width, height;					//size of world 
	private int spawnX, spawnY;					//default start location of player. Only used for testing
	private int numEvents, numDecor;
	public Tile[][] actualTiles;				//matrix of tiles.
	public String Worldname, path;					//name that shows up in nameplate upon entering new location. ""=no nameplate
	private int nameplate=0;					//controls location of nameplate
	double enemyrate;

	public int enemynum;
	public static TreeMap<Integer, Integer> enemy;
	private BufferedImage window = ImageLoader.loadImage("/ui/Window/WindowBlack.png");
	public WorldManager(Game game, String path, String name){
		this.game = game;
		this.Worldname=name;
		this.path = path;
		loadWorld(path);
	}
	
	public void setWorld(String path, String name){
		this.Worldname=name;
		this.path = path;
		loadWorld(path);
	}
		
	public void tick(){
		nameplate++;							//causes nameplate to scroll down initially, than scroll back up.
	}
	
	public void render(Graphics g){
		
		//Sets background to black. Change later perhaps to allow for special background/parallax scrolling
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		
		//renders every tile in the matrix if the map is larger than the screen (For optimality).
		for(int y = (int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH);y < (int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH)+14;y++){
			for(int x = (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH);x < (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)+21;x++){
				if(game!=null){
					if(0<=x && x< width && 0<=y && y<height){
						actualTiles[x][y].render(g, (int)(x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
					}
				}
			}
		}
			
	}
	
	public void renderNameplate(Graphics g){
		//renders scrolling nameplate. 
		if(!this.Worldname.equals("")){
			Utils.drawDialogueBox(g, window, this.Worldname, 15, Color.white, 520, 
					(int)(.005 * (110 - (nameplate - 10) * (nameplate - 10))), 112, 25, 16, true);
		}
	}
	
	//used in rendering tiles. searches the array of tiles in the Tile class for a tile that corresponds to the index of a specific x-y coordinate in the world
	public Tile getTile(int x, int y){
		Tile t = actualTiles[x][y];
		if(t == null)
			return new Black();					
		return t;
	}
	
	
	//ran when setting up a new world. is fed a string that corresponds to the text file of a specific map. 
	//The first 2 numbers in the text file are the height and width of the map
	//next two numbers are the default spawn location. This is only used in testing
	//After that is a single number that equals the number of events in the map
	//Then is a large grid of numbers, each which is the index of a specific tile to be rendered
	//finally is a list of several triplet of numbers, one for each event. These consist of the event id and x-y location
	
	//later, consider adding troop encounters in text files as well to simulate rpg-maker's region stuff
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");			
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		numEvents = Utils.parseInt(tokens[4]);
		numDecor = Utils.parseInt(tokens[5]);
		enemyrate = Utils.parseDouble(tokens[6]);
		enemynum = Utils.parseInt(tokens[7]);
		actualTiles = new Tile[width][height];
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				actualTiles[x][y] = Tile.getTile(Utils.parseInt(tokens[(x+y*width)+8]));
			}
		}
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(!actualTiles[x][y].isWall()){
					TileSorter.adjacencyCheck(actualTiles[x][y], this, x, y);
				}
				else{
					TileSorter.adjacencyWallCheck(actualTiles[x][y], this, x, y);
				}
			}
		}
		
	//enemy encounters are loaded. Each troop consists of a pair of numbers, their id and relative frequency respectively
	//this fills a treemap with these pairs of integers which is checked in the player class when moving
		enemy = new TreeMap<Integer, Integer>();
		for(int i=0; i<enemynum; i++){
			enemy.put(Utils.parseInt(tokens[height*width+8+3*numEvents+3*numDecor+2*i]),Utils.parseInt(tokens[(height*width)+9+3*numEvents+3*numDecor+2*i]));
		}		
	}
	
	public TreeMap<Integer, Integer> getEnemies(){
		return enemy;
	}
	
	public String getPath(){
		return this.path;
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

	public double getEnemyrate() {
		return enemyrate;
	}

	public void setEnemyrate(double enemyrate) {
		this.enemyrate = enemyrate;
	}
	
}
