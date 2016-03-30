package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class TrueSight extends status{
	
	public static String name = "All-Seeing";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public TrueSight(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public TrueSight(Schmuck v,int pr){
		super(name, v,pr);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" sees everything. Everything.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't see everything anymore.";
	}
}
