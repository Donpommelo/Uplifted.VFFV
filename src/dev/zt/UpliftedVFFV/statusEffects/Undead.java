package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Undead extends status{
	
	public static String name = "Undeath";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Undead(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Undead(Schmuck v,int pr){
		super(name,v, pr);
	}	

	public String inflictText(Schmuck s){
		return s.getName()+" became Undead.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" became either dead or alive again.";
	}
}
