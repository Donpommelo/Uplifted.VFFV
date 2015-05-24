package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ElemResBuff extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int statChanged;
	public double statIncrement;
	public ElemResBuff(int i, int stat, double amount){
		super(i, "Resistances Changed", true);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public ElemResBuff(int stat, double amount){
		super("Resistances Changed");
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	
	
	public void run(){
		
	}
	
	public void statchanges(Schmuck s){
		s.buffedRes[this.statChanged]+=statIncrement;
	}
	
	public String inflictText(Schmuck s){
		String stat = "";
		String plusminus = "";
		switch(statChanged){
		case 0:
			stat = "Red";
			break;
		case 1:
			stat = "Blue";
			break;
		case 2:
			stat = "Green";
			break;
		case 3:
			stat = "Yellow";
			break;
		case 4:
			stat = "Purple";
			break;
		case 5:
			stat = "Voide";
			break;
		}
		if(statIncrement>1){
			plusminus = "raised";
		}
		else{
			plusminus = "lowered";
		}
		return s.getName()+"'s "+stat+" Resistance was "+plusminus;

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s resistances went back to normal";
	}
	
	public int getDuration(){
		return duration;
	}
	

}
