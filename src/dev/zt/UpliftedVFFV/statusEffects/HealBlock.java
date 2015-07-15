package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class HealBlock extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public HealBlock(int i, Schmuck perp){
		super(i, "Heal Block", false, true, true, perp);
	}
	
	public HealBlock(Schmuck perp, int pr){
		super("Heal Block", false, false, perp, pr);
	}
	
	public void run(){
		
	}
	

	public String inflictText(Schmuck s){
		return s.getName()+" can no longer heal!";


	}

	public String cureText(Schmuck s){
		return s.getName()+" can heal again!";

	}
	

}
