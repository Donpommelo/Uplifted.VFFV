package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LastBreathStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public LastBreathStatus(Schmuck v,int pr){
		super("Last Breath",v, pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		int numSilenced = 0;
		for(Schmuck guy : bs.bs.alliesSelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
		for(Schmuck guy : bs.bs.enemySelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
		s.buffedStats[2] *= 1+(.1*numSilenced)*(1+s.getEquipPow());

	}
}
