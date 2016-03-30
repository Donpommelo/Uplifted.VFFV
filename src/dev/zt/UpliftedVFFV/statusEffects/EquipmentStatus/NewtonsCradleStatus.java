package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Momentum;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class NewtonsCradleStatus extends status{

	public NewtonsCradleStatus(Schmuck v,int pr){
		super("Carrying Momentum",v, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Newton's Cradle gives "+s.getPronoun(3)+" the Momentum!");
		bs.bp.stm.addStatus(s, new Momentum(1,s,s,50));
	}	
}
