package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.RunawayNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Pursued extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Pursued(int i, Schmuck perp){
		super(i, "Pursued", false, true, false, perp);
	}
	
	public Pursued(Schmuck perp){
		super("Pursued", true, false, perp);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Run Away")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new RunawayNothing(0),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Pursued.";

	}

	public String cureText(Schmuck s){
		return s.getName()+" shook off the pursuer.";
	}
	
	public int getDuration(){
		return duration;
	}

}
