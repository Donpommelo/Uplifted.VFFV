package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class OrangeInfusion extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public OrangeInfusion(Schmuck perp, int pr){
		super("Orange Infusion", false, false, perp, pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){		
		return damage - (int)(5*(1+perp.getEquipPow()));
	}	
}
