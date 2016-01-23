package dev.zt.UpliftedVFFV.statusEffects.Stats;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class StatBuffMult extends status{
	
	public static String name = "Stats Changed";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public int statChanged;
	public double statIncrement;
	public StatBuffMult(int i, int stat, double amount, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public StatBuffMult(int stat, double amount, int pr){
		super(name, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
			
	public void statchanges(Schmuck s){
		s.buffedStats[this.statChanged]*=statIncrement;
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
		return s.getName()+"'s "+stat+" was "+plusminus+"!";
	}

	public String cureText(Schmuck s){
		return "";//s.getName()+"'s stats went back to normal";
	}
	
	public int stackingEffect(){
		return 2;
	}
}
