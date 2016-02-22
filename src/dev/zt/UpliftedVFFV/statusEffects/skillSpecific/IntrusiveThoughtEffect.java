package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IntrusiveThoughtEffect extends status{
	
	public static String name = "Intrusive Thinking";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public IntrusiveThoughtEffect(Schmuck perp, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public int stackingEffect(){
		return 5;
	}
}
