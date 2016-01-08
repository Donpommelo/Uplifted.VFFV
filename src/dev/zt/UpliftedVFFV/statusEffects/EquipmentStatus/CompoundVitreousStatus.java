package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;
import dev.zt.UpliftedVFFV.statusEffects.Unresistant;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CompoundVitreousStatus extends status{

	public CompoundVitreousStatus(int pr){
		super("Compound Vitreous", pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(!bs.bp.em.getAcc(a.user, a.target,a.skill.getBaseAcc()) && a.skill.canMiss() && !bs.bp.stm.checkStatus(a.user, new TrueSight(50))){
			bs.bp.bt.addScene(s.getName()+"'s Compound Vitreous focuses!");
			bs.bp.stm.addStatus(s, new TrueSight(0,s.itemDummy, 50));
			bs.bp.stm.addStatus(s, new Unresistant(2, s.itemDummy, 5));
		}
	}
	
}
