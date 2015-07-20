package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Queried extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public Queried(Schmuck perp, int pr){
		super("Queried",false, true, perp, pr);
	}	

	public String inflictText(Schmuck s){
		return "Information about "+s.getName()+" was researched.";
	}

	public String cureText(Schmuck s){
		return "";
	}
}
