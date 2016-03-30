package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class incapacitate extends status{
	
	public static String name = "incapacitated";
	public static Boolean perm = true;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public incapacitate(Schmuck perp, Schmuck vic){
		super(1, name, perm, visible, removedEnd, decay, perp, vic, 100);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was Incapacitated!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" was Revived!";
	}
	
/*	public BattleAnimation getBa(Schmuck s) {
		return new DeathAnim(s);
	}*/
	
	public Boolean isDisable(){
		return true;
	}
}
