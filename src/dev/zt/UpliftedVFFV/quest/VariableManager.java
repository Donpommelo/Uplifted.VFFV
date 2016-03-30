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
 16: Rooms Passed: West Cubicle Dungeon 
 17: Last Direction (0: South, 1: East, 2: West, 3: North)
 18: Semiphore Sign: West Dungeon Extended (0: S, 1: E, 2: W, 3: N, 4:F, 5:B, 6:L, 7: R)
 19: Floor Manager Favor
 20: Glimpses of the End used
 21: Global Level Modifier
 22: Levels Drained in Wetworks Dungeon
 23: Aquarium Quest Variable: Location of Strikebreaker
 24: Petting Fish Selection ()
 25: Petting Fish Level
 26: Buttonman's Button-down Buttons
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
