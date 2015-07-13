package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class incapacitate extends status{
	
	
	public int stack;
	public BattleState bs;
	public incapacitate(Schmuck perp){
		super("incapacitated", true, false, perp);
	}
	
	
	
	public void run(){
		
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was incapacitated.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks ok again.";
	}

}
