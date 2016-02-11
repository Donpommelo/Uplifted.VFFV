package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Untouchable extends status{
	
	public static String name = "Untouchable";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Untouchable(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public void preActionTarget(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,a.getTarget().getName()+"'s Untargetability prevents "+s.getName()+" from targeting "+a.getTarget().getPronoun(3)+"!"),bs));
	}
		
	public String inflictText(Schmuck s){
		return s.getName()+" became Untargetable.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks targetable again.";
	}
}
