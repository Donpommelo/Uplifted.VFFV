package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Untouchable extends status{
	
	

	public Untouchable(int i, Schmuck perp, int pr){
		super(i, "Untouchable", false, true, true, perp, pr);
	}
		
	public String inflictText(Schmuck s){
		return s.getName()+" became untargetable.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks targetable again.";
	}
}
