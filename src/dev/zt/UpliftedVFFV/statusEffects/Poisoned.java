package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poisoned extends status{
	
	public static String name = "Poison";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Poisoned(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.inflicter = perp;
	}
	
	public Poisoned(int pr){
		super(name, pr);
	}
		
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		bs.bp.em.hpChange(-(s.getMaxHp()/100+inflicter.getGreenPoints()/2),inflicter,s,2);
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
