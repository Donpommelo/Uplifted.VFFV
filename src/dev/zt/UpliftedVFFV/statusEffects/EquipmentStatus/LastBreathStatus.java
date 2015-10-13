package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LastBreathStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	int numSilenced;
	public LastBreathStatus(Schmuck perp, int pr){
		super("Last Breath", false, false, perp, pr);
		numSilenced = 0;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		numSilenced = 0;
		for(Schmuck guy : bs.bs.alliesSelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
		for(Schmuck guy : bs.bs.enemySelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
	}
	
	public void onAction(BattleState bs, Action a){
		numSilenced = 0;
		for(Schmuck guy : bs.bs.alliesSelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
		for(Schmuck guy : bs.bs.enemySelectable){
			if(bs.bp.stm.checkStatus(guy, new Silenced(guy,0)));
			numSilenced++;
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[2] *= 1+(.1*numSilenced)*(1+s.getEquipPow());
	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		numSilenced = 0;
	}
}
