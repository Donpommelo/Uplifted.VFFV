package dev.zt.UpliftedVFFV.Decorations;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Decorations.decor.Decor;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.utils.Utils;

public class DecorManager {
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
	
	public void renderBelow(Graphics g){
		for(int i = 0; i<Decorations.length; i++){
			if(Decorations[i].renderBelow() == -1 ||(Decorations[i].renderBelow() != 1 && gs.getPlayer().getPlayerY() > DecorCoords[1][i])){
				if(!Decorations[i].followCamera()){
					Decorations[i].render(g, (int)(DecorCoords[0][i] - game.getGameCamera().getxOffset()), (int)(DecorCoords[1][i] - game.getGameCamera().getyOffset()));
				}
				else{
					Decorations[i].render(g, (int)(DecorCoords[0][i]), (int)(DecorCoords[1][i]));
				}
			}
		}
	}
	
	public void renderAbove(Graphics g){
		for(int i = 0; i<Decorations.length; i++){
			if(Decorations[i].renderBelow() == 1||(Decorations[i].renderBelow() != -1 && gs.getPlayer().getPlayerY() <= DecorCoords[1][i])){
				if(!Decorations[i].followCamera()){
					Decorations[i].render(g, (int)(DecorCoords[0][i] - game.getGameCamera().getxOffset()), (int)(DecorCoords[1][i] - game.getGameCamera().getyOffset()));
				}
				else{
					Decorations[i].render(g, (int)(DecorCoords[0][i]), (int)(DecorCoords[1][i]));
				}
			}
		}
	}
	
	//Loads all the events in a given map.
	private void loadDecor(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		textBlock = Utils.parseInt(tokens[0])*Utils.parseInt(tokens[1]) + 8 + 3*Utils.parseInt(tokens[4]) + 2*Utils.parseInt(tokens[7]);
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
