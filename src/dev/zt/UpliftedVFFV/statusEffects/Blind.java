package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Blind extends status{

	public static String name = "Blinded";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Blind(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Blind(int pr){
		super(name, pr);
	}	
	
	public void statchanges(Schmuck s){
		s.bonusStats[0] -= .5;

	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was Blinded!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s vision returned!";
	}
}
