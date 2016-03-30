package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Impatient extends status{
	
	public double percent;
	public static String name = "Impatience";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Impatient(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Impatient(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Dilly Dally")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s Impatience prevents "+s.getPronoun(3)+" from Waiting!"),bs));
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Impatient and can Wait no longer!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer Impatient!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
