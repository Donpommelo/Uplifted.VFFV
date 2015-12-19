package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SimpleMindStatus extends status{
	
	public SimpleMindStatus(int pr){
		super("Simple", pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		for(status meep : s.statuses){
			if(!meep.perm && !meep.getName().equals("incapacitated")) {
				bs.bp.stm.removeStatus(s, meep);
			}
		}
		bs.bp.stm.addStatus(s, st);
	}
}
