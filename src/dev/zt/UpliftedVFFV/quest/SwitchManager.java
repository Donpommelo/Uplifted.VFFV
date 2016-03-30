package dev.zt.UpliftedVFFV.quest;

import dev.zt.UpliftedVFFV.Game;

public class SwitchManager {

	public Game game;
	public boolean[] switches = new boolean[256];
	
	
/*
 0: Meep
 1: OpeningSceneDone
 2: JorgeBeaten
 3: TutorialBeaten
 4: Tutorial Fight done
 5: Quest Begin: Find Suite 521
 6: Quest Begin: Carloc's Errand
 7: Quest Begin: Return envelope to Carloc (Informant Talked to)
 8: Quest Begin: Deliver envelope to Speros
 9: Carloc Quest Finished: B1 Company Town Unlocked
 10: Summoning Learned
 11: Floor 1 Visited
 12: Floor 2 Visited
 13: Floor 3 Visited
 14: Floor 4 Visited
 15: Floor 5 Visited
 16: Floor 6 Visited
 17: Floor 7 Visited
 18: Floor 8 Visited
 19: Floor 9 Visited
 20: Floor 10 Visited
 21: Floor 11 Visited
 22: Floor 12 Visited
 23: Floor 13 Visited
 24: Floor B1 Visited
 25: Floor B2 Visited
 26: West Cubicle Dungeon Complete
 27: West Cubicle Dungeon Extended Complete
 28: South Aquarium Tank Flooded
 29: East Aquarium Tank Flooded
 30: West Aquarium Tank Flooded
 31: Aquarium Dungeon Flooded
 32: Spa Extra Options explained.
 33: Underwater discovered
 34: Currently underwater.

 
 */
	
	public SwitchManager(Game g){
		this.game = g;
		for(int i = 0; i < switches.length; i++){
			switches[i] = false;
		}
	}
	
	public boolean getSwitch(int i){
		return switches[i];
	}
	
	public void setSwitch(int i, boolean set){
		switches[i] = set;
	}
}
