package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.StunnedNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Stunned extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Stunned(int i, Schmuck perp){
		super(i, "Stunned", false, true, false, perp);
	}
	
	public Stunned(Schmuck perp){
		super("Stunned", true, false, perp);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new StunnedNothing(0),bs));
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Stunned.";

	}

	public String cureText(Schmuck s){
		return s.getName()+" recovered from the stun.";
	}
	
	public int getDuration(){
		return duration;
	}

}
