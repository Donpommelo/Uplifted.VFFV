package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class incapacitate extends status{
	
	public static String name = "incapacitated";
	public static Boolean perm = true;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public incapacitate(Schmuck perp){
		super(1, name, perm, visible, removedEnd, decay, perp, 100);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was incapacitated.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks ok again.";
	}
	
	public Boolean isDisable(){
		return true;
	}
}
