package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MponCrit extends status{

	double percent;
	public MponCrit(double amount, int pr){
		super("Mp on Crit", pr);
		this.percent = amount;
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" restores Motivation from the blow!");
		bs.bp.em.bpChange((int)(percent*perp.getMaxBp()), perp);
	}
}
