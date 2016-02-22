package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;

public class Invisible extends status{
	
	public static String name = "Invisibility";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Invisible(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
		
	public String inflictText(Schmuck s){
		return s.getName()+" became Invisible.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks visable again.";
	}
}
