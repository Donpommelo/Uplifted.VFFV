package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Stunned extends status{
	
	public static String name = "Stun";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Stunned(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Stunned(Schmuck v,int pr){
		super(name,v, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is disabled and cannot move!"),bs));
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Stunned!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" recovered from the stun!";
	}
	
	public Boolean isDisable(){
		return true;
	}
	
	public Boolean isBad(){
		return true;
	}
}
