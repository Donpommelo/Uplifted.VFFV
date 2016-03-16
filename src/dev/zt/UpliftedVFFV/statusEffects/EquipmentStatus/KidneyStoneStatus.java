package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KidneyStoneStatus extends status{

	public KidneyStoneStatus(int pr){
		super("Filtering", pr);
	}
		
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,s,50))){
			if(st.isBad() && !st.perm){
				bs.bp.bt.addScene(s.getName()+"'s Kidney Stone removes the ailment!");
				bs.bp.stm.removeStatus(s, st);
				bs.bp.stm.addStatus(s, new CoolingDown(3, s,s, 50));
			}
		}
	}
	
}
