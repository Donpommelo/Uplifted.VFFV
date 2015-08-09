package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Haunt;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DeadMansHandStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;	
	public DeadMansHandStatus(Schmuck perp, int pr){
		super("Haunting", false, false, perp,pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		if(bs.bp.stm.checkStatus(s, new incapacitate(s))){
			bs.bp.TurnOrderQueue.add(new Action(s, s, new Haunt(0), bs));
		}
	}
}
