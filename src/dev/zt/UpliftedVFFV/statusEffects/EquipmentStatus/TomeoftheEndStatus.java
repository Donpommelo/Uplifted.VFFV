package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class TomeoftheEndStatus extends status{
	
	public TomeoftheEndStatus(int pr){
		super("Ending", pr);
	}
	
	public void onHit(Schmuck perp,Schmuck vic, BattleState bs){
		if(Math.random()<.01*(1+perp.getEquipPow())){
			bs.bp.bt.addScene(perp.getName()+"'s Tome of the End inflicts Death");
			bs.bp.em.hpChange(-9999, perp, vic, 1);
		}
	}
}
