package dev.zt.UpliftedVFFV.statusEffects.Stats;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class ElemPointsBuffMult extends status{
	
	public static String name = "Elementally Aligned";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public int statChanged;
	public double statIncrement;
	public ElemPointsBuffMult(int i, int stat, double amount, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public ElemPointsBuffMult(int stat, double amount, int pr){
		super("Elementally Aligned", pr);
		this.statChanged = stat;
		this.statIncrement = amount;
	}
	
	public void statchanges(Schmuck s){
		s.buffedElemPoints[this.statChanged]*=statIncrement;
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
			stat = "???";
			break;
		}
		if(statIncrement>1){
			plusminus = "more";
		}
		else{
			plusminus = "less";
		}
		return s.getName()+" became "+ plusminus +" "+ stat + " aligned!";
	}

	public String cureText(Schmuck s){
		return "";//s.getName()+"'s elemental alignments went back to normal";
	}
	
	public int stackingEffect(){
		return 2;
	}
}
