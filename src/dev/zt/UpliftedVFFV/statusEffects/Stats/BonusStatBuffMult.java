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
	public BonusStatBuffMult(int i, int stat, double amount, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public BonusStatBuffMult(int stat, double amount, Schmuck v,int pr){
		super(name, v,pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
		
	public void statchanges(Schmuck s){
		if(this.isEquipment() && statChanged != 6 && statChanged != 10 && statChanged != 26 && statChanged != 36){
			s.bonusStats[this.statChanged] *= (statIncrement * (1+s.getEquipPow()));
		}
		else{
			s.bonusStats[this.statChanged]*=statIncrement;
		}
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
			stat = "Script Drop Rate";
			break;
		case 3:
			stat = "Exp Gain Rate";
			break;
		case 4:
			stat = "Item Drop Rate";
			break;
		case 5:
			stat = "Oxygen Level";
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
			stat = "Monster Level";
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
		case 33:
			stat = "Channeling Bonus";
			break;
		case 34:
			stat = "Hp Regeneration";
			break;
		case 35:
			stat = "Mp Regeneration";
			break;
		case 36:
			stat = "Primary Defense Stat";
			break;
		case 37:
			stat = "Attack Damage";
			break;
		case 38:
			stat = "Damage Reduction";
			break;
		case 39:
			stat = "Haggling Ability";
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
	
	public String getName(){
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
			stat = "Script Drop Rate";
			break;
		case 3:
			stat = "Exp Gain Rate";
			break;
		case 4:
			stat = "Item Drop Rate";
			break;
		case 5:
			stat = "Oxygen Level";
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
			stat = "Monster Level";
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
		case 33:
			stat = "Channeling Bonus";
			break;
		case 34:
			stat = "Hp Regeneration";
			break;
		case 35:
			stat = "Mp Regeneration";
			break;
		case 36:
			stat = "Primary Defense Stat";
			break;
		case 37:
			stat = "Attack Damage";
			break;
		case 38:
			stat = "Damage Reduction";
			break;
		case 39:
			stat = "Haggling Ability";
			break;
		}
		if(statIncrement>1){
			plusminus = "+";
		}
		else{
			plusminus = "-";
		}
		return plusminus+" "+stat;
	}

	public String cureText(Schmuck s){
		return "";//s.getName()+"'s stats went back to normal";
	}
	
	public int stackingEffect(){
		return 2;
	}
	
	public Boolean isBad(){
		if(this.statChanged == 6 || this.statChanged == 26 || this.statChanged == 36){
			return false;
		}
		else{
			if(statIncrement >= 1){
				return false;
			}
			else{
				return true;
			}
		}
	}
	
	public Boolean isStat(){
		return true;
	}
}
