package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Disarmed extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Disarmed(int i, Schmuck perp, int pr){
		super(i, "Disarmed", false, true, false, perp,pr);
	}
	
	public Disarmed(Schmuck perp, int pr){
		super("Disarmed", true, false, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Attack")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to use attack, but was Disarmed."),bs));
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
