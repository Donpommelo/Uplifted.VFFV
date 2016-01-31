package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class HealonCrit extends status{

	double percent;
	public HealonCrit(double amount, int pr){
		super("Heal on Crit", pr);
		this.percent = amount;
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" restores HealtH from the blow!");
		bs.bp.em.hpChange((int)(percent*perp.getMaxBp()), perp,vic,6);
	}
}
