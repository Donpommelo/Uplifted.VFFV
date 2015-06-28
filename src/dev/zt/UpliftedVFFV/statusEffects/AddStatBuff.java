package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class AddStatBuff extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int statChanged;
	public double statIncrement;
	public AddStatBuff(int i, int stat, double amount, Schmuck perp){
		super(i, "Stats Changed",false, false, true, perp);
		this.statChanged = stat;
		this.statIncrement = amount;
//		this.perp = perp;
	}
	
	public AddStatBuff(int stat, double amount, Schmuck perp){
		super("Stats Changed",false,true, perp);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	
	
	public void run(){
		
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[this.statChanged]+=statIncrement;
	}
	
	public String inflictText(Schmuck s){
		String stat = "";
		String plusminus = "";
		switch(statChanged){
		case 0:
			stat = "Health";
			break;
		case 1:
			stat = "Motivation";
			break;
		case 2:
			stat = "Power";
			break;
		case 3:
			stat = "Defense";
			break;
		case 4:
			stat = "Speed";
			break;
		case 5:
			stat = "Skill";
			break;
		case 6:
			stat = "Intelligence";
			break;
		case 7:
			stat = "Luck";
			break;
		}
		if(statIncrement>1){
			plusminus = "raised";
		}
		else{
			plusminus = "lowered";
		}
		return s.getName()+"'s "+stat+" was "+plusminus;

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s stats went back to normal";
	}
	
	public int getDuration(){
		return duration;
	}
	

}
