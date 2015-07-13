package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Queried extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public int stack;
	public Queried(Schmuck perp){
		super("Queried",false, true, perp);
		stack = 0;
	}
	
	
	
	public void run(){
		
	}
	

	public String inflictText(Schmuck s){
		return "Information about "+s.getName()+" was researched.";


	}

	public String cureText(Schmuck s){
		return "";

	}
	

}
