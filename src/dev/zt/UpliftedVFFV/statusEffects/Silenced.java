package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.ablities.SilencedNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Silenced extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Silenced(int i){
		super(i, "Silenced", true);
	}
	
	public Silenced(){
		super("Silenced");
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(!a.skill.getName().equals("Attack") && !a.skill.getName().equals("Item") && !a.skill.getName().equals("Dilly Dally") && !a.skill.getName().equals("Run Away")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new SilencedNothing(0,a.skill.getName()),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Silenced.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s voice came back.";
	}
	
	public int getDuration(){
		return duration;
	}

}
