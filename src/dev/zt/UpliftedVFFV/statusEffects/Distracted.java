package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Distracted extends status{
	
	public static String name = "Distract";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Distracted(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Distracted(int pr){
		super(name, pr);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Distracted!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Distracted!";
	}
	
	public Boolean isDisable(){
		return true;
	}
	
	public Boolean isBad(){
		return true;
	}
}
