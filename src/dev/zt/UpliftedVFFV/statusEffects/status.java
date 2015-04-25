package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class status {
	public int duration;
	public Boolean perm=false;
	public status(int i){
		this.duration=i;
	}
	
	public status(){
		perm=true;
	}
	
	public Boolean restrict(){
		return false;
	}
	

	
	public void run(Schmuck s){
		
	}
	
	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}

}
