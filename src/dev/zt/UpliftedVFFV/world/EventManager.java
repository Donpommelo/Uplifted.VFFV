package dev.zt.UpliftedVFFV.world;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.tiles.Tile;
import dev.zt.UpliftedVFFV.utils.Utils;


public class EventManager {

	private Game game;
	private GameState gs;
	private int width, height;
	//	private int X, Y;
	private int numevents;
	public static int[][] events;
	public static Event[] EventTracker;
	
	public EventManager(Game game, GameState gamestate, String path) {
		this.game=game;
		this.gs = gamestate;
		loadEvent(path);
	}
	
	public void setWorld(String path){
		loadEvent(path);
	}

	public void tick(){
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				if(x<events.length-1 && y<events[x].length-1){ 
					if(events[x][y] != 0 && getEvent(x,y) != null){
						getEvent(x, y).tick(gs);
					}
				}	
			}
		}
	}
		
	public void renderBelow(Graphics g){
		for(int y = (int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH)-1;y<(int)(gs.getPlayer().getPlayerY()/32);y++){
			for(int x = (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)-1;x < (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)+22;x++){
				if(x>-1 && x<width && y>-1 && y < height){
					if(events[x][y] != 0 && getEvent(x,y).drawn() && getEvent(x, y).renderBelow() != 1){
						if(getEvent(x,y).getTest()!=null){
							getEvent(x, y).render(g, (int)(getEvent(x, y).getTest().getX() * 32 - game.getGameCamera().getxOffset()), (int)(getEvent(x, y).getTest().getY() * 32 - game.getGameCamera().getyOffset()));
						}
						else{
							getEvent(x, y).render(g, (int)(x*32 - game.getGameCamera().getxOffset()),(int)(y*32 - game.getGameCamera().getyOffset()));
						}
					}
				}
			}
		}
		for(int y = (int)(gs.getPlayer().getPlayerY()/32);y <(int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH)+15;y++){
			for(int x = (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)-1;x < (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)+22;x++){
				if(x>-1 && x<width && y>-1 && y < height){
					if(events[x][y] != 0 && getEvent(x,y).drawn() && getEvent(x, y).renderBelow() == -1){
						getEvent(x, y).render(g, (int)(x*32 - game.getGameCamera().getxOffset()),(int)(y*32 - game.getGameCamera().getyOffset()));
					}
				}
			}
		}
	}
	
	public void renderAbove(Graphics g){
		for(int y = (int)(gs.getPlayer().getPlayerY()/32);y <(int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH)+15;y++){
			for(int x = (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)-1;x < (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)+22;x++){
				if(x>-1 && x<width && y>-1 && y < height){
					if(events[x][y] != 0 && getEvent(x,y).drawn() && getEvent(x, y).renderBelow() != -1){
						if(getEvent(x,y).getTest()!=null){
							getEvent(x, y).render(g, (int)(getEvent(x, y).getTest().getX() * 32 - game.getGameCamera().getxOffset()), (int)(getEvent(x, y).getTest().getY() * 32 - game.getGameCamera().getyOffset()));
						}
						else{
							getEvent(x, y).render(g, (int)(x*32 - game.getGameCamera().getxOffset()),(int)(y*32 - game.getGameCamera().getyOffset()));
						}
						
					}
				}
			}
		}
		for(int y = (int)(game.getGameCamera().getyOffset()/Tile.TILEWIDTH)-1;y<(int)(gs.getPlayer().getPlayerY()/32);y++){
			for(int x = (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)-1;x < (int)(game.getGameCamera().getxOffset()/Tile.TILEWIDTH)+22;x++){
				if(x>-1 && x<width && y>-1 && y < height){
					if(events[x][y] != 0 && getEvent(x,y).drawn() && getEvent(x, y).renderBelow() == 1){
						getEvent(x, y).render(g, (int)(x*32 - game.getGameCamera().getxOffset()),(int)(y*32 - game.getGameCamera().getyOffset()));
					}
				}
			}
		}
	}
		
	//Returns the event at a given x,y coordinate
	public Event getEvent(int x,int y){
		Event e = gs.getEvents()[events[x][y]];
		if(e == null)
			return Event.event0;
		return e;
	}
	
	//Loads all the events in a given map.
	private void loadEvent(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		numevents=Utils.parseInt(tokens[4]);
		events = new int[width][height];
		for(int y = 0;y<height;y++){
			for(int x = 0;x < width;x++){
				events[x][y] = 0;
			}
		}
		for(int i=0;i<numevents;i++){
			if(gs.getEvents()[Utils.parseInt(tokens[(height*width)+8+3*i])].loaded()){
				events[Utils.parseInt(tokens[(height*width)+9+3*i])][Utils.parseInt(tokens[(height*width)+10+3*i])]=Utils.parseInt(tokens[(height*width)+8+3*i]);
				gs.getEvents()[Utils.parseInt(tokens[(height*width)+8+3*i])].moveTo(Utils.parseInt(tokens[(height*width)+9+3*i]),Utils.parseInt(tokens[(height*width)+10+3*i]));
				if(gs.getEvents()[Utils.parseInt(tokens[(height*width)+8+3*i])].getTest()!=null){
					gs.getEvents()[Utils.parseInt(tokens[(height*width)+8+3*i])].getTest().setX(Utils.parseInt(tokens[(height*width)+9+3*i]));
					gs.getEvents()[Utils.parseInt(tokens[(height*width)+8+3*i])].getTest().setY(Utils.parseInt(tokens[(height*width)+10+3*i]));
				}
			}
		}
	}

	public static int[][] getEvents() {
		return events;
	}

	public static void setEvents(int[][] events) {
		EventManager.events = events;
	}
}
