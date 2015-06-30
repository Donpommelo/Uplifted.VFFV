package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BonusStatBuff extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int statChanged;
	public double statIncrement;
	public BonusStatBuff(int i, int stat, double amount, Schmuck perp){
		super(i, "Stats Changed",false, false, true, perp);
		this.statChanged = stat;
		this.statIncrement = amount;
//		this.perp = perp;
	}
	
	public BonusStatBuff(int stat, double amount, Schmuck perp){
		super("Stats Changed",false,true, perp);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	
	
	public void run(){
		
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[this.statChanged]+=statIncrement;
	}
	
	public String inflictText(Schmuck s){
		String stat = "";
		String plusminus = "";
		switch(statChanged){
		case 0:
			stat = "Accuracy";
			break;
		case 1:
			stat = "Evasion";
			break;
		case 2:
			stat = "Bonus Script Drop";
			break;
		case 3:
			stat = "Bonus Exp Drop";
			break;
		case 4:
			stat = "Bonus Item Drop";
			break;
		case 5:
			stat = "Bonus Critical Chance";
			break;
		case 6:
			stat = "Elemental Alignment";
			break;
		case 7:
			stat = "Damage Amplification";
			break;
		case 8:
			stat = "Damage Resistance";
			break;
		case 9:
			stat = "Item Power";
			break;
		case 10:
			stat = "Equipment Power";
			break;
		case 11:
			stat = "Bonus Monster Level";
			break;
		case 12:
			stat = "Combat Frequency";
			break;
		case 13:
			stat = "Motivation Costs";
			break;
		case 14:
			stat = "Combat Initiative";
			break;
		case 15:
			stat = "Damage Variance";
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
