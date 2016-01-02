package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BloodwoodsOvercoatStatus extends status{
	
	public BloodwoodsOvercoatStatus(int pr){
		super("Bloodwood's Blessing", pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		int cost = (int)(s.getMaxHp() * 0.2);
		if(s.getCurrentHp() > cost && st.isBad() && !st.perm){
			bs.bp.bt.textList.add("Bloodwood's Overcoat cleanses "+s.getName()+" of "+s.getPronoun(1)+" debuff.");
			s.hpChange(-cost);
			bs.bp.stm.removeStatus(s, st);
		}
	}
}
