package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Untouchable extends status{
	
	
//	public BattleState bs;
	public Untouchable(int i){
		super(i, "Untouchable", true);
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
