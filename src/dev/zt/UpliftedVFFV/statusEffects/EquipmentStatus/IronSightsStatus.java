package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IronSightsStatus extends status{
	
	public Boolean perm = false;
	public Boolean visible = true;
	public IronSightsStatus(Schmuck v,int pr){
		super("Iron Sighted",v, pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		if(bs.bp.TurnOrderQueue.get(-1) != null){
			if(bs.bp.TurnOrderQueue.get(-1).getUser() == s){
				s.setBonusAcc(s.getBonusAcc()+.50);
				s.setCritChance(s.getCritChance()+.30);
			}
		}
	}
}
