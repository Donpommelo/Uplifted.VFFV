package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class WindUpPunchEffect extends status{
	
	public static String name = "Winding Up";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Schmuck Target;
	public WindUpPunchEffect(int i, Schmuck perp, Schmuck target, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.Target = target;
	}

	public void doneChanneling(Schmuck s, BattleState bs){
		if(bs.bp.getSelectableEnemies(s).contains(Target)){
			bs.bp.bt.addScene(s.getName()+" unleashed "+s.getPronoun(1)+" Wind-Up Punch!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, Target) * 1.5);
			bs.bp.em.hpChange(damage, perp, Target,6);
		}
		bs.bp.stm.removeStatus(s, this);
	}
	
	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}
	
}
