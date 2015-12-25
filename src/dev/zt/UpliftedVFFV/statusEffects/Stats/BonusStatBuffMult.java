package dev.zt.UpliftedVFFV.statusEffects.Stats;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BonusStatBuffMult extends status{
	
	public static String name = "Stats Changed";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public int statChanged;
	public double statIncrement;
	public BonusStatBuffMult(int i, int stat, double amount, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public BonusStatBuffMult(int stat, double amount, int pr){
		super(name, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
		
	public void statchanges(Schmuck s){
		s.bonusStats[this.statChanged]*=statIncrement;
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
			stat = "Motivation Cost Reduction";
			break;
		case 14:
			stat = "Combat Initiative";
			break;
		case 15:
			stat = "Damage Variance";
			break;
		case 16:
			stat = "Critical Chance";
			break;
		case 17:
			stat = "Critical Multiplier";
			break;
		case 18:
			stat = "Heal Power";
			break;
		case 19:
			stat = "Red Resistance";
			break;
		case 20:
			stat = "Blue Resistance";
			break;
		case 21:
			stat = "Green Resistance";
			break;
		case 22:
			stat = "Yellow Resistance";
			break;
		case 23:
			stat = "Purple Resistance";
			break;
		case 24:
			stat = "??? Resistance";
			break;
		case 25:
			stat = "Runaway Chance";
			break;
		case 26:
			stat = "Primary Damage Stat";
			break;
		case 27:
			stat = "Level Requirement Modification";
			break;
		case 28:
			stat = "Critical Resistance";
			break;
		case 29:
			stat = "Regeneration Bonus";
			break;
		case 30:
			stat = "Charge Bonus";
			break;
		case 31:
			stat = "Cooldown Bonus";
			break;
		case 32:
			stat = "Crit Avoidance";
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
		return "";//s.getName()+"'s stats went back to normal";
	}
	
	public int stackingEffect(){
		return 2;
	}
}
