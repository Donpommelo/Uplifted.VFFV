package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Isolated extends status{
	
	public static String name = "Disarmed";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Isolated(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Isolated(int pr){
		super(name, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(bs.bp.getSelectableAllies(s).contains(a.target)){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s Isolation prevents "+s.getPronoun(3)+" from targeting an ally!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Disarmed.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s arms grew back.";
	}
	
	public Boolean isBad(){
		return true;
	}
}
