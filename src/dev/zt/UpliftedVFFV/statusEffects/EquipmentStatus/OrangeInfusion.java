package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class OrangeInfusion extends status{
	
	public OrangeInfusion(Schmuck v,int pr){
		super("Orange Infusion", v,pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){		
		return damage - (int)(7*(1+perp.getEquipPow()));
	}	
}
