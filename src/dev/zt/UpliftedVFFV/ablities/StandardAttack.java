package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StandardAttack extends Skills {

	public StandardAttack(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-(perp.BuffedPow*perp.BuffedPow)/vic.BuffedDef,vic);
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" attacks "+vic.getName()+"!";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return perp.BuffedPow*perp.BuffedPow/vic.BuffedDef+" damage is dealt!";
	}

}
