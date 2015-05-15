package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class incapacitate extends status{
	
	
	public incapacitate(){
		
	}
	
	
	
	public void run(){
		
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was incapacitated.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks ok again.";
	}

}
