package dev.zt.UpliftedVFFV.quest;

import dev.zt.UpliftedVFFV.Game;

public class VariableManager {

	public Game game;
	public int[] variables = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
/*
 0: Meep
 1: Elevator Floor
 2: Elevator (S,E,W,N)
 3: Elevator Points
 4: PenPal Favor
 5: Anxiety
 6: Pleasure
 7: Despair
 8: Wonder
 9: Ennui
 10: Ennui Ceiling
 11: 
 */
	
	public VariableManager(Game g){
		this.game = g;
	}
	
	public int getVar(int i){
		return variables[i];
	}
	
	public void setVar(int i, int set){
		variables[i] = set;
	}
}
