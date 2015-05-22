package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class BeefedUp extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BattleState bs;
	public BeefedUp(int i, BattleState bs){
		super(i, "Beefed Up", true, bs);
		this.bs = bs;
	}
	
	
	
	public void run(){
		
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[2]*=1.5;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks beefed up.";

	}

	public String cureText(Schmuck s){
		return s.getName()+" no longer looks notably beefy.";
	}
	
	public int getDuration(){
		return duration;
	}

}
