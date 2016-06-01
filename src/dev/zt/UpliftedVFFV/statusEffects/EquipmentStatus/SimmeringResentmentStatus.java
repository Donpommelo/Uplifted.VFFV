package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SimmeringResentmentStatus extends status{
	
	Schmuck spited;
	public SimmeringResentmentStatus(Schmuck v,int pr){
		super("Resentful", v,pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int finaldamage = damage;
		if(spited != null){
			if(spited == vic){
				finaldamage *= 1.25;
			}
			else{
				finaldamage *= .75;
			}
		}
		else{
			finaldamage *= .75;
		}
		return finaldamage;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(spited != null){
			spited = perp;
		}
		else{
			if(perp != spited){
				spited = perp;
			}
		}
		return damage;
	}	
}
