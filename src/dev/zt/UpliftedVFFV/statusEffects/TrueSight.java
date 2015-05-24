package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TrueSight extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public TrueSight(int i, double amount){
		super(i, "True Sight", true);

	}
	
	public TrueSight(double amount){
		super("True Sight");

	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[0]+=100;
	}

	
	public String inflictText(Schmuck s){
		return s.getName()+" sees everything. Everything.";

	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't see anything anymore.";
	}
	
	public int getDuration(){
		return duration;
	}

}
