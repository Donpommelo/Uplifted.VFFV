package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Misaligned extends status{
	
	
	public static String name = "Misalignment";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Misaligned(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Misaligned(int pr){
		super(name, pr);
	}	
		
	public String inflictText(Schmuck s){
		return s.getName()+" was Misaligned!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is correctly aligned again.";
	}
	
	public int stackingEffect(){
		return 4;
	}
}
