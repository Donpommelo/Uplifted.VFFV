package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Untouchable extends status{
	
	public static String name = "Untouchable";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Untouchable(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
		
	public String inflictText(Schmuck s){
		return s.getName()+" became untargetable.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks targetable again.";
	}
}
