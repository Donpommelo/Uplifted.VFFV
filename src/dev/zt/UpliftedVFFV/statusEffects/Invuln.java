package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Invuln extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public int stack;
	public BattleState bs;
	public Invuln(int i, BattleState bs){
		super(i, "Invulnerable", true, bs);
		stack = 0;
	}
	
	
	
	public void run(){
		
	}
	

	public String inflictText(Schmuck s){
		return s.getName()+" was made invulnerable.";


	}

	public String cureText(Schmuck s){
		return "";

	}
	

}
