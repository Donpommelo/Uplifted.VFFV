package dev.zt.UpliftedVFFV.quest;

import dev.zt.UpliftedVFFV.Game;

public class SwitchManager {

	public Game game;
	public boolean switch1 = false;
	public boolean switch2 = false;
	public boolean switch3 = false;
	public boolean[] switches = {false,false,false,false,false,false};
	
/*
 0: Meep
 1: OpeningSceneDone
 2: JorgeBeaten
 3: TutorialBeaten
 4: Quest: Find Suite 521
 5: Quest: Carloc's Errand
 6: 
 7: 
 
 */
	
	public SwitchManager(Game g){
		this.game = g;
	}
	
	public boolean getSwitch(int i){
		return switches[i];
	}
	
	public void setSwitch(int i, boolean set){
		switches[i] = set;
	}
}
