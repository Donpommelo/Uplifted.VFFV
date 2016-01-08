package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class TouchofDeathStatus extends status{
	
	public TouchofDeathStatus(int pr){
		super("Killing Touch", pr);
	}
	
	public void onHit(Schmuck perp,Schmuck vic, BattleState bs){
		if(Math.random()<.01*(1+perp.getEquipPow())){
			bs.bp.bt.addScene(perp.getName()+"'s Touch of Death inflicts Death");
			bs.bp.em.hpChange(-9999, perp, vic, 6);
		}
	}
}
