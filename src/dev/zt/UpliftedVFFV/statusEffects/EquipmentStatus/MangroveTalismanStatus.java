package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MangroveTalismanStatus extends status{
	
	public boolean rolled;
	public status absorbed;
	public MangroveTalismanStatus(Schmuck v,int pr){
		super("Mangroved", v,pr);
		this.rolled = false;
	}

	public void startoffightEffect(Schmuck s, BattleState bs){//
		rolled = false;
		absorbed = null;
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.isBad() && !st.perm && rolled == false && bs.bp.stm.checkStatus(s, st)){
			rolled = true;
			bs.bp.bt.addScene(s.getName()+"'s Mangrove Talisman absorbs the status!");
			bs.bp.stm.removeStatus(s, st);
			absorbed = st;
		}
	}
	
	public void onActionTarget(BattleState bs, Action a){
		if(absorbed != null && !bs.bp.getSelectableAllies(perp).contains(a.getUser())){
			if(Math.random() < .5){
				bs.bp.bt.addScene(perp.getName()+"'s Mangrove Talisman inflicts absorbed status!");
				absorbed.setVic(a.getUser());
				bs.bp.stm.addStatus(a.getUser(), absorbed);
			}
		}
	}
}
