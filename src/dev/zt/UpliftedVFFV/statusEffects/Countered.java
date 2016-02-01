package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Countered extends status{
	
	public static String name = "Countered";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck Counterer;
	public Countered(int i, Schmuck perp, Schmuck counterer, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.Counterer = counterer;
	}
	
	public Countered(int pr){
		super(name, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		
	}
	
	public void onAction(BattleState bs, Action a){
		if(a.getTarget() == Counterer && a.getSkill().getTargetType() == 0 && !bs.bp.getSelectableAllies(a.getUser()).contains(Counterer)){
			bs.bp.bt.addScene(Counterer.getName()+" Counters!");
			int damage = (int)(bs.bp.em.logScaleDamage(Counterer, a.getUser()) * 0.5);
			bs.bp.em.hpChange(damage, Counterer, a.getUser(),6);
		}
	}

	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}

}
