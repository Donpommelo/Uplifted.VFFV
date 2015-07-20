package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Deplorable extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Deplorable(Schmuck perp, int pr){
		super("Deplorable", false, false, perp, pr);
	}
	
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		if(s.getCurrentHp() != s.getMaxHp()){
			bs.bp.bt.textList.add(s.getName()+"'s Deplorable Apparatus regrows damaged parts!");
			bs.bp.em.hpChange(s.getMaxHp()/3,s.getItemDummy(),s,6);
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[0]/=3;
	}
}
