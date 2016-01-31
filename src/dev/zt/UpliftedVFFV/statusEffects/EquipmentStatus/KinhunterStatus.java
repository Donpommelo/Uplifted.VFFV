package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KinhunterStatus extends status{

	public KinhunterStatus(int pr){
		super("Kin Hunter", pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(perp.getElemAlignment() != 0 && perp.getElemAlignment() == vic.getElemAlignment()){
			damage *= 1.5*(1+perp.getEquipPow());
		}
		return damage;
	}	
}
