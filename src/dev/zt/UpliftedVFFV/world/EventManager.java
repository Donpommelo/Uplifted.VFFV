package dev.zt.UpliftedVFFV.world;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.utils.Utils;


	public class EventManager {
	
	private Game game;
	private int width, height;
	private int X, Y;
	private int numevents;
	public static int[][] events;
	
	public EventManager(Game game, String path) {
		this.game=game;
		loadEvent(path);
	}

public void tick(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(events[x][y]!=0&&getEvent(x,y)!=null){
					getEvent(x, y).render(g, (int)(x*32 - game.getGameCamera().getxOffset()),(int)(y*32 - game.getGameCamera().getyOffset()));
				}
			}
		}
		
	}
	
	public static Event getEvent(int x,int y){
		Event e = Event.events[events[x][y]];
		if(e == null)
			return Event.event0;
		return e;
	}
	
	
	private void loadEvent(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		numevents=Utils.parseInt(tokens[4]);
		events = new int[width][height];
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				events[x][y]=0;
				
			}
		}
		for(int i=0;i<numevents;i++){
			events[Utils.parseInt(tokens[(height*width)+6+3*i])][Utils.parseInt(tokens[(height*width)+7+3*i])]=Utils.parseInt(tokens[(height*width)+5+3*i]);
		}
		


		
	}

}
