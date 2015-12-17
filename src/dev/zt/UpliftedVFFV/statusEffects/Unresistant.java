package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Unresistant extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Unresistant(int i, Schmuck perp, int pr){
		super(i, "Unresistant",  false, true, true, perp, pr);
	}
	
	public Unresistant(Schmuck perp, int pr){
		super("Unresistant", true, true, perp, pr);
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
