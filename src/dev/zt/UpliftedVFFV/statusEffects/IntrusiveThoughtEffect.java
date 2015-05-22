package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class IntrusiveThoughtEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int stack;
	public BattleState bs;
	public IntrusiveThoughtEffect(int i, BattleState bs){
		super(i, "Intrusive Thoughts", true, bs);
		stack = 0;
		this.bs = bs;
	}
	
	
	
	public void run(){
		
	}
	

	public String inflictText(Schmuck s){
		return s.getName()+" just had an unpleasant thought.";


	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Intrusive Thoughts fade.";

	}
	

}
