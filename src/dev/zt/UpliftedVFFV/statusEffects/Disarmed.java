package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.DisarmedNothing;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.ablities.SilencedNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Disarmed extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Disarmed(int i){
		super(i, "Disarmed", true);
	}
	
	public Disarmed(){
		super("Disarmed");
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Attack")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new DisarmedNothing(0),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Disarmed.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s arms grew back.";
	}
	
	public int getDuration(){
		return duration;
	}

}
