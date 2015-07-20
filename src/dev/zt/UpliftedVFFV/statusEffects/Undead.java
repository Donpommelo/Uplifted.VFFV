package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Undead extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public Undead(int i, Schmuck perp){
		super(i, "Undead", false, true, true, perp);
	}
	
	public Undead(Schmuck perp, int pr){
		super("Undead", false, false, perp,pr);
	}	

	public String inflictText(Schmuck s){
		return s.getName()+" became undead.";
	}

	public String cureText(Schmuck s){
		return "";
	}
}
