package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class status {
	public int duration;
	public String name;
	public Boolean perm = false;
	public Boolean visible = true;
	public Boolean removedEnd = true;
	public int stack;
	public status(int i, String n, Boolean end){
		this.duration=i;
		this.perm = false;
		this.name = n;
		this.removedEnd = end;
	}
	
	public status(){
		this.perm=true;
		this.removedEnd=false;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	
	public Boolean restrict(){
		return false;
	}
	
	
	
	public void run(Schmuck s){
		
	}
	
	public void statchanges(Schmuck s){
//		System.out.println(s.buffedStats[3]);
	}
	
	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}
	
	public String getName(){
		return name;
	}

}
