package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Invuln extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public int stack;
	public Invuln(int i, Schmuck perp){
		super(i, "Invulnerable", false, true, true, perp);
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
