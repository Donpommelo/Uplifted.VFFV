package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class MeterBlock extends status{
	
	public static String name = "Meter Blocked";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public MeterBlock(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public MeterBlock(int pr){
		super(name, pr);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" can no longer regain Mp!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" can regain Mp again!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
