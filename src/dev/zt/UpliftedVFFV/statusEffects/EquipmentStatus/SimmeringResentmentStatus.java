package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SimmeringResentmentStatus extends status{
	
	Schmuck spited;
	public SimmeringResentmentStatus(int pr){
		super("Resentful", pr);
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
			if(perp == vic){
				bs.bp.bt.addScene(vic.getName()+"'s Simmering Resentment directs spite towards "+vic.getPronoun(3)+"self!");
			}
			else{
				bs.bp.bt.addScene(vic.getName()+"'s Simmering Resentment directs spite towards "+perp.getName()+"!");
			}
		}
		else{
			if(perp != spited){
				spited = perp;
				if(perp == vic){
					bs.bp.bt.addScene(vic.getName()+"'s Simmering Resentment directs spite towards "+vic.getPronoun(3)+"self!");
				}
				else{
					bs.bp.bt.addScene(vic.getName()+"'s Simmering Resentment directs spite towards "+perp.getName()+"!");
				}
			}
		}
		return damage;
	}	
}
