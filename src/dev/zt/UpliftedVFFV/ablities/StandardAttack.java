package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class StandardAttack extends Skills {

	public StandardAttack(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic){
		vic.CurrentHp-=((perp.BuffedPow*perp.BuffedPow)/vic.BuffedDef);
		if(vic.CurrentHp<=0){
			vic.CurrentHp=0;
		}
	}

}
