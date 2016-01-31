package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EnergyUnethical extends status{
	
	public EnergyUnethical(int pr){
		super("Unethical", pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Energy Source drains Power from allies!");
		int mp = 0;
		for(Schmuck ally : bs.bp.getSelectableAllies(s)){
			if(ally != s){
				mp += (int)(.1 * ally.getMaxBp());
				bs.bp.em.bpChange(-(int)(.1 * ally.getMaxBp()), ally);
			}
		}
		bs.bp.em.bpChange((int)(mp * 1.5 * (1 + s.getEquipPow())), s);
	}
}
