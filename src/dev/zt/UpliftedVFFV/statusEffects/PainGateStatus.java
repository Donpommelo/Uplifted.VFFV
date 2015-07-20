package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PainGateStatus extends status{
	
	public int duration;

	public Boolean perm = false;
	public Boolean visible = true;
	public PainGateStatus(Schmuck perp, int pr){
		super("Damage Round", false, false, perp, pr);
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
