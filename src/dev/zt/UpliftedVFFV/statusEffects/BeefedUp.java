package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefedUp extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BeefedUp(int i, Schmuck perp, int pr){
		super(i, "Beefed Up", false, true, false, perp,pr);
	}
			
	public void statchanges(Schmuck s){
		int bonus = (10-3*duration)*(10-3*duration)/100;
		s.buffedStats[2] *= (1+bonus);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks beefed up.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" no longer looks notably beefy.";
	}
}
