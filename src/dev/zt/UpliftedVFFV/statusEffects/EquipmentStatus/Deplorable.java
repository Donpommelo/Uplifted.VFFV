package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.UseItemAnim;
import dev.zt.UpliftedVFFV.inventory.equipables.DeploreApp;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Deplorable extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Deplorable(int pr, Schmuck vic){
		super("Deplorable", vic, pr);
	}
	
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		if(s.getCurrentHp() != s.getMaxHp() && !bs.bp.stm.checkStatus(s, new incapacitate(s,s))){
			BattleAnimation ba = new UseItemAnim(new DeploreApp(),vic);
			bs.bp.bt.addScene(s.getName()+"'s Deplorable Apparatus regrows damaged parts!",ba,this,true);
//			bs.bp.em.hpChange((int)(s.getMaxHp()/3*(1+s.getEquipPow())*(1+s.getRegenBonus())),s,s,6);
		}
	}
	
	public void postAnimRun(BattleState bs){
		bs.bp.em.hpChange((int)(vic.getMaxHp()/5*(1+vic.getEquipPow())*(1+vic.getRegenBonus())),vic,vic,6);
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[0]/=4;
	}
}
