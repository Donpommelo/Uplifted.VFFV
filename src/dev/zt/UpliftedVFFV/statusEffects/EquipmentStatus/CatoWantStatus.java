package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class CatoWantStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public CatoWantStatus(Schmuck v,int pr){
		super("Wanting", v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		int overkill = s.getCurrentBp() - (int)(a.skill.getCost()*(1-a.user.getMpCost()));
		if(overkill <= 0){
			if(s.getCurrentHp() >= -(overkill*2+5)){
				bs.bp.bt.addScene(s.getName()+" doesn't have the Motivation to cast "+a.getSkill().getName()+"!");
				bs.bp.bt.addScene(s.getName()+" casts it anyways using Catalogue of Want!");
				bs.bp.em.hpChange((int)(overkill*2-5),s.itemDummy,s,6);
				s.setCurrentBp((int)(a.skill.getCost()*(1+a.user.getMpCost())));
			}
		}
	}
}
