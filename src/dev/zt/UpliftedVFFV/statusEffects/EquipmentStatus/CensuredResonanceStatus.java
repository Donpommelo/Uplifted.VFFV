package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CensuredResonanceStatus extends status{
	
	public CensuredResonanceStatus(int pr){
		super("Resonating", pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.getName() == "Stats Changed" || st.getName() == "Elementally Aligned"){
			if(!st.perm){
				bs.bp.bt.textList.add(s.getName()+"'s Censured Resonance echoes the buff!");
				for(Schmuck ally : bs.bp.getSelectableAllies(s)){
					if(ally != s && !bs.bp.stm.checkStatus(ally, this)){
						bs.bp.stm.addStatus(ally, st);
					}
				}
			}
		}
	}
}
