package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Purified extends status{
	
	public static String name = "Purification";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;	
	public Purified(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Purified(Schmuck v,int pr){
		super(name,v, pr);
	}	
		
	public String inflictText(Schmuck s){
		return s.getName()+" was Purified.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Purified.";
	}
}
