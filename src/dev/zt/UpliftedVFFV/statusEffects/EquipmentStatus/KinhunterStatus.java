package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KinhunterStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public KinhunterStatus(Schmuck perp, int pr){
		super("Kin Hunter", false, false, perp, pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(perp.getElemAlignment() != 0 && perp.getElemAlignment() == vic.getElemAlignment()){
			damage *= 1.3*(1+perp.getEquipPow());
		}
		return damage;
	}	
}
