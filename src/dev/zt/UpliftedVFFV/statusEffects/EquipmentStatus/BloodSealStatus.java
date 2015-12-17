package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BloodSealStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BloodSealStatus(Schmuck perp, int pr){
		super("Blood Pact Made", false, false, perp, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(bs.bp.roundNum == 10){
			bs.bp.bt.textList.add(s.getName()+"'s Blood Seal glows with a sinister energy!");
			for(status meep : s.statuses){
				if(!meep.perm && !meep.getName().equals("incapacitated")) {
					bs.bp.stm.removeStatus(s, meep);
				}
			}
			s.hpChange(-1000000);
		}
	}
}
