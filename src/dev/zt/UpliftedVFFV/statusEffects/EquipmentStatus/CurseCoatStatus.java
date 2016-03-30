package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CurseCoatStatus extends status{
	
	public boolean rolled;
	public CurseCoatStatus(Schmuck v,int pr){
		super("Cursed?", v,pr);
		this.rolled = false;
	}
	
	public void onActionUser(BattleState bs, Action a){
		rolled = false;
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.isBad() && !st.perm && rolled == false && bs.bp.stm.checkStatus(s, st)){
			rolled = true;
			bs.bp.bt.addScene(s.getName()+"'s Curse Coat replaces the debuff with a different one!");
			bs.bp.stm.removeStatus(s, st);
			status newstatus = bs.bp.stm.randomBad(st.getDuration(), st.perp, s);
			bs.bp.stm.addStatus(s, newstatus);
			
		}
	}
}
