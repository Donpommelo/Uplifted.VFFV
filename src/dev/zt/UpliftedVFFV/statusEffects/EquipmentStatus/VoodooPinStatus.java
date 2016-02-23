package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class VoodooPinStatus extends status{
	
	public VoodooPinStatus(int pr){
		super("Voodoo", pr);
	}

	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.perp != null){
			if(st.isBad() && !st.perm && bs.bp.stm.checkStatus(s, st) && bs.bp.getSelectableEnemies(s).contains(st.perp)){
				bs.bp.bt.addScene(s.getName()+"'s Voodoo Pin reflects the debuff!");
				bs.bp.stm.addStatus(st.perp, st);
			}
		}
	}
}
