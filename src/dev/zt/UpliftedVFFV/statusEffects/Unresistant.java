package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Unresistant extends status{
	
	public static String name = "Unresistant";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Unresistant(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Unresistant(int pr){
		super(name, pr);
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[19] = 0;
		s.bonusStats[20] = 0;
		s.bonusStats[21] = 0;
		s.bonusStats[22] = 0;
		s.bonusStats[23] = 0;
		s.bonusStats[24] = 0;

	}

	public String inflictText(Schmuck s){
		return s.getName()+"'s Resistances were nullified!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Resistances returned!";
	}
}
