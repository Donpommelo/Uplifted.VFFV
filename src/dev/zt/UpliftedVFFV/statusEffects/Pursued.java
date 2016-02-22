package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Pursued extends status{
	
	public static String name = "Pursued";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Pursued(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Pursued(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Run Away")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to run but was Pursued!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Pursued and cannot run away!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" shook off the pursuer.";
	}
	
	public Boolean isBad(){
		return true;
	}
}
