package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PainGateStatus extends status{
	
	public PainGateStatus(int pr){
		super("Damage Round", pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if((-damage)%20 <= 10){
			return damage - damage%20;
		}
		else{
			return damage - damage%20 - 20;
		}
	}	
}
