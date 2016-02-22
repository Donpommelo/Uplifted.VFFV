package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Blind extends status{

	public static String name = "Blind";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Blind(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Blind(int pr){
		super(name, pr);
	}	
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.getSkill().canMiss()){
			
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName() + "'s Blind caused "+s.getPronoun(3)+" to miss!"),bs));
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was Blinded!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s vision returned!";
	}
}
