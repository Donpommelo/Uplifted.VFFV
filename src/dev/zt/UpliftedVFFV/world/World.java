package dev.zt.UpliftedVFFV.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.utils.Utils;

public class World {
	
	private Game game;
	private int width, height;					//size of world 
	private int spawnX, spawnY;					//default start location of player. Only used for testing
	private int[][] tiles;						//matrix of ints. these correspond to the index of specific tiles in the Tile class
	public String Worldname;					//name that shows up in nameplate upon entering new location. ""=no nameplate
	private int nameplate=0;					//controls location of nameplate
	
	public World(Game game, String path, String name){
		this.game = game;
		this.Worldname=name;
		loadWorld(path);
		
	}
	
	public void tick(){
		nameplate++;							//causes nameplate to scroll down initially, than scroll back up.
		
	}
	
	public void render(Graphics g){
		
		//Sets background to black. Change later perhaps to allow for special background/parallax scrolling
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		
		//renders every tile in the matrix. 	
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(game!=null){
					getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
					
				}
		}
		}
		
		//renders scrolling nameplate. 
		if(!this.Worldname.equals("")){
			g.setColor(new Color(102, 178,255, 255));
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.fillRect(550,(int)(.01*(110-(nameplate-10)*(nameplate-10))), 90, 25);
			g.setColor(Color.BLACK);
			g.drawString(this.Worldname, 552,(int)(20+.01*(110-(nameplate-10)*(nameplate-10))));
		}
		
		
		
	}
	
	//used in rendering tiles. searches the array of tiles in the Tile class for a tile that corresponds to the index of a specific x-y coordinate in the world
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.black;					
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
		tiles = new int[width][height];
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+5]);
				
			}
		}

		
	}
}
