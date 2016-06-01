package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AkadamaOrbStatus extends status{
	
	public AkadamaOrbStatus(Schmuck v,int pr){
		super("Red Earth Flesh",v, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(bs.bp.TurnOrderQueue.get(0) != null){
			if(bs.bp.TurnOrderQueue.get(0).getUser() == vic){
				bs.bp.bt.addScene(vic.getName()+"'s Akadama Orb blocks damage!");
				return 0;
			}
		}
		return damage;
	}	
}
