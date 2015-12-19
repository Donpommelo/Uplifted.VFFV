package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Queried extends status{
	
	public static String name = "Queried";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public Queried(Schmuck perp, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
	}	

	public String inflictText(Schmuck s){
		return "Information about "+s.getName()+" was researched.";
	}
}
