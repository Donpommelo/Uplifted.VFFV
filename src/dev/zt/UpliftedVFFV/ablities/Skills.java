package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Skills {
	
	public String name;
	public int cost;
	public boolean startTeamTarget;
	public Skills(int index){
		name = "";
		cost = 0;
	}
	
	public void run(Schmuck user, Schmuck target, BattleState bs){

	}
	
	public String useText(Schmuck user, Schmuck target){
		return "";
	}
	
	public String resultText(Schmuck user, Schmuck target){
		return "";
	}

	public String getName() {
		return "meep";
	}

	public int getCost() {

		return cost;
	}
	
	public boolean startTarget(){
		return false;
	}
	
	public void TOQChange(Action a, BattleState bs){
		
	}
	


}
