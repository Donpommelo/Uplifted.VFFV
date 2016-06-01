package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EmpathyLinkStatus extends status{
	
	public EmpathyLinkStatus(Schmuck v,int pr){
		super("Empathy",v, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Empathy Link equalizes the Hp of living allies!");
		int totalHp = 0;
		for(Schmuck e : bs.bp.getSelectableAllies(s)){
			totalHp += e.getCurrentHp();
		}
		for(Schmuck e : bs.bp.getSelectableAllies(s)){
			e.hpChange(totalHp/bs.bp.getSelectableAllies(s).size()-e.getCurrentHp());
		}
	}
}
