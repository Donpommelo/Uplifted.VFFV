package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poisoned extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Poisoned(int i, Schmuck perp, int pr){
		super(i, "Poisoned", false, true, false, perp, pr);
	}
	
	public Poisoned(Schmuck perp, int pr){
		super("Poisoned", true, false, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+" takes damage from Poison!");
		bs.bp.em.hpChange(-s.getCurrentHp()/10,perp,s,6);	
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Poisoned!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" was cured of Poison!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
