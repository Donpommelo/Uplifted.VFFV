package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class TrueSight extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public TrueSight(int i, double amount, Schmuck perp, int pr){
		super(i, "True Sight",  false, true, true, perp, pr);
	}
	
	public TrueSight(double amount, Schmuck perp, int pr){
		super("True Sight", true, true, perp, pr);
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[0]+=1000;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" sees everything. Everything.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't see anything anymore.";
	}
}
