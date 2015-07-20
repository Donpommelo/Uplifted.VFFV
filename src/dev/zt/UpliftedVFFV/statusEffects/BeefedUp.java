package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefedUp extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BeefedUp(int i, Schmuck perp, int pr){
		super(i, "Beefed Up", false, true, false, perp,pr);
	}
	
	public BeefedUp(Schmuck perp, int pr){
		super("Beefed Up", true, false, perp,pr);
	}
		
	public void statchanges(Schmuck s){
		s.buffedStats[2]*=1.5;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks beefed up.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" no longer looks notably beefy.";
	}
}
