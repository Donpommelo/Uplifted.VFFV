package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CensuredResonanceStatus extends status{
	
	public CensuredResonanceStatus(Schmuck v,int pr){
		super("Resonating", v,pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.isStat()){
			if(!st.perm){
				bs.bp.bt.addScene(s.getName()+"'s Censured Resonance echoes the buff!");
				for(Schmuck ally : bs.bp.getSelectableAllies(s)){
					if(ally != s && !bs.bp.stm.checkStatus(ally, this)){
						bs.bp.stm.addStatus(ally, st);
					}
				}
			}
		}
	}
}
