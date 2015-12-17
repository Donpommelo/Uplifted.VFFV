package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Purified extends status{
	
	
	public int stack;
	public BattleState bs;
	public Purified(int i, Schmuck perp, int pr){
		super(i,"Purified", false, true, true, perp, pr);
	}
	
	public Purified(Schmuck perp, int pr){
		super("Purified", false, false, perp, pr);
	}	
		
	public String inflictText(Schmuck s){
		return s.getName()+" was Purified.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Purified.";
	}
}
