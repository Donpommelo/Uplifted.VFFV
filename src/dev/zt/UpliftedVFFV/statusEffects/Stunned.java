package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Stunned extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Stunned(int i, Schmuck perp, int pr){
		super(i, "Stunned", false, true, false, perp, pr);
	}
	
	public Stunned(Schmuck perp, int pr){
		super("Stunned", true, false, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is disabled and cannot move."),bs));
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Stunned.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" recovered from the stun.";
	}
	
	public Boolean isBad(){
		return true;
	}
}
