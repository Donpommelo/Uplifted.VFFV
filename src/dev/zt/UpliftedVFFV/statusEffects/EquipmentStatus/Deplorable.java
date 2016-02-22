package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Deplorable extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Deplorable(int pr){
		super("Deplorable", pr);
	}
	
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		if(s.getCurrentHp() != s.getMaxHp() && !bs.bp.stm.checkStatus(s, new incapacitate(s))){
			bs.bp.bt.addScene(s.getName()+"'s Deplorable Apparatus regrows damaged parts!");
			bs.bp.em.hpChange((int)(s.getMaxHp()/3*(1+s.getEquipPow())),s,s,6);
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[0]/=4;
	}
}
