package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Insolvent extends status{
	
	public static String name = "Insolvency";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Insolvent(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Insolvent(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Use Item")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to use an Item but couldn't!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" became Insolvent and can no longer use Items!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Insolvent!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
