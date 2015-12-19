package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Invuln extends status{
	
	public static String name = "Invulnerable";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Invuln(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was made invulnerable!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s invulnerablility wore off!";
	}
}
