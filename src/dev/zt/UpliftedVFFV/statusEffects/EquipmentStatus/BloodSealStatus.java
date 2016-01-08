package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BloodSealStatus extends status{

	public BloodSealStatus(int pr){
		super("Blood Pact Made", pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(bs.bp.roundNum == 9){
			bs.bp.bt.addScene(s.getName()+"'s Blood Seal glows with a sinister energy!");
			for(status meep : s.statuses){
				if(!meep.perm && !meep.getName().equals("incapacitated")) {
					bs.bp.stm.removeStatus(s, meep);
				}
			}
			s.hpChange(-1000000);
		}
	}
}
