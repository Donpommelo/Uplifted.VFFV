package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Unhealthy extends status{
	
	public static String name = "Unhealthy";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Unhealthy(int i, Schmuck perp, Schmuck vic, int pr) {
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Unhealthy(Schmuck v,int pr){
		super(name, v, pr);
	}	

}
