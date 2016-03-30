package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefedUp extends status{

	public static String name = "Beefy";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public BeefedUp(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public BeefedUp(Schmuck v,int pr){
		super(name,v,pr);
	}	
	
	public void statchanges(Schmuck s){
		int bonus = (10-3*duration)*(10-3*duration)/100;
		s.buffedStats[2] *= (1+bonus);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks Beefed Up!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" no longer looks notably beefy!";
	}
}
