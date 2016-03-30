package dev.zt.UpliftedVFFV.Decorations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Decorations.decor.Decor;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.utils.Utils;

public class DecorManager {
	
	//Decor are sticker-like decorations that can be placed between squares and do not interact with the player.
	
	private int numdecor;
	
	//width,height and enemy info only useful for parsing the text file.
	private int textBlock;
	private Game game;
	private GameState gs;
	public static Decor[] Decorations;
	public static int[][] DecorCoords;

	public DecorManager(Game g, GameState gamestate, String path) {
		loadDecor(path);
		this.game = g;
		this.gs = gamestate;
	}
	
	public void setWorld(String path){
		loadDecor(path);
	}
	
	public void tick(){
		
	}
	
	//Renders all decor that shows up underneath everything including tiles.
	//will be eventually used for parallax stuff
	public void renderBelowBelow(Graphics g){
		for(int i = 0; i<Decorations.length; i++){
			if(Decorations[i].renderBelow() == -2 && Decorations[i].isRendered(gs)){
				Decorations[i].render(g, game, DecorCoords[0][i],DecorCoords[1][i]);
			}
		}
	}
	
	//Renders all decor that shows up underneath the player.
	//This includes decor specifically designated to always render low.
	//This also includes standard decor that is higher up than the player.
	public void renderBelow(Graphics g){
		for(int i = 0; i<Decorations.length; i++){
			if(Decorations[i].renderBelow() == -1 ||(Decorations[i].renderBelow() != -2 &&
					Decorations[i].renderBelow() != 1 && gs.getPlayer().getPlayerY() > DecorCoords[1][i]
							&& Decorations[i].isRendered(gs))){
				Decorations[i].render(g, game, DecorCoords[0][i],DecorCoords[1][i]);
			}
		}
	}
	
	//Renders all decor that shows up underneath the player.
	//This includes decor specifically designated to always render high.
	//This also includes standard decor that is lower down than the player.
	public void renderAbove(Graphics g){
		for(int i = 0; i<Decorations.length; i++){
			if(Decorations[i].renderBelow() == 1||(Decorations[i].renderBelow() != -2 &&
					Decorations[i].renderBelow() != -1 && gs.getPlayer().getPlayerY() <= DecorCoords[1][i]
							&& Decorations[i].isRendered(gs))){
				Decorations[i].render(g, game, DecorCoords[0][i],DecorCoords[1][i]);
			}
		}
	}
	
	//Loads all the events in a given map.
	private void loadDecor(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		textBlock = Utils.parseInt(tokens[0])*Utils.parseInt(tokens[1]) + 8 + 3*Utils.parseInt(tokens[4]);
		numdecor=Utils.parseInt(tokens[5]);
		Decorations = new Decor[numdecor];
		DecorCoords = new int[2][numdecor];
		for(int i=0;i<numdecor;i++){
			Decorations[i] = Decor.decors[Utils.parseInt(tokens[textBlock + i*3])];
			DecorCoords[0][i] = Utils.parseInt(tokens[textBlock + i*3 + 1]);
			DecorCoords[1][i] = Utils.parseInt(tokens[textBlock + i*3 + 2]);
		}
	}
}
