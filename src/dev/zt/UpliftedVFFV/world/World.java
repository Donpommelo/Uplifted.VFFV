package dev.zt.UpliftedVFFV.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.utils.Utils;

public class World {
	
	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	public String Worldname;
	private int nameplate=0;
	
	public World(Game game, String path, String name){
		this.game = game;
		this.Worldname=name;
		loadWorld(path);
		
	}
	
	public void tick(){
		nameplate++;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(game!=null){
					getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
					
				}
		}
		}
		if(!this.Worldname.equals("")){
			g.setColor(new Color(102, 178,255, 255));
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.fillRect(550,(int)(.01*(110-(nameplate-10)*(nameplate-10))), 90, 25);
			g.setColor(Color.BLACK);
			g.drawString(this.Worldname, 552,(int)(20+.01*(110-(nameplate-10)*(nameplate-10))));
		}
		
		
		
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.black;
		return t;
	}
	
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
