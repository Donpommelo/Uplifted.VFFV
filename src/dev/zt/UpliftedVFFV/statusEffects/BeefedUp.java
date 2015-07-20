package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefedUp extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BeefedUp(int i, Schmuck perp){
		super(i, "Beefed Up", false, true, false, perp);
	}
	
	public BeefedUp(Schmuck perp){
		super("Beefed Up", true, false, perp);
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
