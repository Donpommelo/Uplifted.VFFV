package dev.zt.UpliftedVFFV.quest;

import dev.zt.UpliftedVFFV.Game;

public class VariableManager {

	public Game game;
	public int[] variables = new int[256];
	
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
 11: Janitor Points
 12: Number of Janitor Closets found.
 13: East Offices Mind Control Device Setting.
 14: Summoning Objects Found
 15: Spa Choice: None, Regen, +ML, -Combat Freq, +Stats - Drops
 16: 
 17: 
 18: 
 */
	
	public VariableManager(Game g){
		this.game = g;
		for(int i = 0; i < variables.length; i++){
			variables[i] = 0;
		}
	}
	
	public int getVar(int i){
		return variables[i];
	}
	
	public void setVar(int i, int set){
		variables[i] = set;
	}
}
