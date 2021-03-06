package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;
import dev.zt.UpliftedVFFV.statusEffects.Unresistant;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CompoundVitreousStatus extends status{

	public CompoundVitreousStatus(Schmuck v,int pr){
		super("Compound Vitreous", v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(!bs.bp.em.getAcc(a.user, a.target,a.skill.getBaseAcc()) && a.skill.canMiss() && !bs.bp.stm.checkStatus(a.user, new TrueSight(a.user,50))){
			bs.bp.bt.addScene(s.getName()+"'s Compound Vitreous focuses!");
			bs.bp.stm.addStatus(s, new TrueSight(0,s, s,50));
			bs.bp.stm.addStatus(s, new Unresistant((int)(2*(1-s.getEquipPow())), s, s,5));
		}
	}
	
}
