package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.DisarmedNothing;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.ablities.SilencedNothing;
import dev.zt.UpliftedVFFV.ablities.StunnedNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Stunned extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Stunned(int i){
		super(i, "Stunned", true);
	}
	
	public Stunned(){
		super("Stunned");
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
