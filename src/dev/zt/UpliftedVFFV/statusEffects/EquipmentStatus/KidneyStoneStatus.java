package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KidneyStoneStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public KidneyStoneStatus(Schmuck perp, int pr){
		super("Filtering", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		setCooldown(0);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(getCooldown() == 0){
			if(st.isBad()){
				if(!st.perm){
					bs.bp.bt.textList.add(s.getName()+"'s Kidney Stone removes the ailment!");
					bs.bp.stm.removeStatus(s, st);
					setCooldown((int)(4 - s.getCooldownBonus()));
				}
			}
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(getCooldown() >0){
			setCooldown(getCooldown()-1);
		}
	}	
}
