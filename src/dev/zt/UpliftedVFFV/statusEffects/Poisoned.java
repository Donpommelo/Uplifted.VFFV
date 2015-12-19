package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poisoned extends status{
	
	public static String name = "Poisoned";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Poisoned(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Poisoned(int pr){
		super(name, pr);
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
	
	public int stackingEffect(){
		return 1;
	}
	
	public Boolean isBad(){
		return true;
	}
}
