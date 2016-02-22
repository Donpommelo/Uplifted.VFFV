package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MeditateEffect extends status{
	
	public static String name = "Meditating";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public MeditateEffect(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}

	public void doneChanneling(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" looks spiritually refreshed!");
		bs.bp.em.hpChange(s.getBaseHp(), s, s, 6);
		bs.bp.stm.removeStatus(s, this);
	}
		
}
