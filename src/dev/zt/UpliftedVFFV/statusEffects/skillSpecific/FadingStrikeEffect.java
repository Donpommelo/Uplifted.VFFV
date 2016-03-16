package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FadingStrikeEffect extends status{
	
	public static String name = "Fading to Strike";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Schmuck Target;
	public FadingStrikeEffect(int i, Schmuck perp, Schmuck vic, Schmuck target, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic,pr);
		this.Target = target;
	}

	public void doneChanneling(Schmuck s, BattleState bs){
		if(bs.bp.getSelectableEnemies(s).contains(Target)){
			bs.bp.bt.addScene(s.getName()+" Strikes from the Shadows!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, Target)* 2.0);
			bs.bp.em.hpChange(damage, perp, Target,6);
		}
		bs.bp.stm.removeStatus(s, this);
	}
	
}
