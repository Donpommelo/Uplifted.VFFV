package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Countered extends status{
	
	public static String name = "Counter";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Countered(int i, Schmuck perp, Schmuck counterer, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Countered(int pr){
		super(name, pr);
	}
	
	public void onActionTarget(BattleState bs, Action a){
		if(a.getSkill().getTargetType() == 0 && !bs.bp.getSelectableAllies(a.getTarget()).contains(a.getUser())){
			bs.bp.bt.addScene(a.getTarget().getName()+" Counters the attack!");
			int damage = (int)(bs.bp.em.logScaleDamage(a.getTarget(), a.getUser()) * 0.5);
			bs.bp.em.hpChange(damage, a.getTarget(), a.getUser(),6);
		}
	}
}
