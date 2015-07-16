package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Misaligned extends status{
	
	
	public int stack;
	public BattleState bs;
	public Misaligned(int i, Schmuck perp){
		super(i,"Misaligned", false, true, true, perp);
	}
	
	public Misaligned(Schmuck perp){
		super("Misaligned", false, false, perp);
	}
	
	
	
	public void run(){
		
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was misaligned.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is correctly aligned again.";
	}

}
