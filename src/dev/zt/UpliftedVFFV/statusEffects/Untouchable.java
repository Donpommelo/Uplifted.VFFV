package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Untouchable extends status{
	
	
//	public BattleState bs;
	public Untouchable(int i, Schmuck perp){
		super(i, "Untouchable", false, true, true, perp);
//		this.bs = bs;
	}
	
	
	
	public void run(){
		
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became untargetable.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks targetable again.";
	}

}
