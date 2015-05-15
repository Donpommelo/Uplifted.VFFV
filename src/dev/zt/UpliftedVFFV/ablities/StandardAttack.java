package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StandardAttack extends Skills {

	public StandardAttack(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		bs.bp.bt.textList.add(perp.buffedStats[2]*perp.buffedStats[2]/vic.buffedStats[3]+" damage is dealt!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3],vic);
	}
	

}
