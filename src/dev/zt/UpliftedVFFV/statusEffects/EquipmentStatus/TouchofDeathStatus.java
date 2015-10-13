package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class TouchofDeathStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int cooldown;
	public TouchofDeathStatus(Schmuck perp, int pr){
		super("Killing Touch", false, false, perp, pr);
	}
	
	public void onHit(Schmuck perp,Schmuck vic, BattleState bs){
		if(Math.random()<.01*(1+perp.getEquipPow())){
			bs.bp.bt.textList.add(perp.getName()+"'s Touch of Death inflicts Death");
			bs.bp.em.hpChange(-9999, perp, vic, 6);
		}
	}
}
