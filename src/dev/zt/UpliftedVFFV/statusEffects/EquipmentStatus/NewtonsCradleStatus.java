package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Momentum;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class NewtonsCradleStatus extends status{

	public NewtonsCradleStatus(int pr){
		super("Carrying Momentum", pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.stm.addStatus(s, new Momentum(1,s,50));
	}	
}
