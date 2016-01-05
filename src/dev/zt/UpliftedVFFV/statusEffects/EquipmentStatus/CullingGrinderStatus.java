package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CullingGrinderStatus extends status{
	
	public CullingGrinderStatus(int pr){
		super("Culling", pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Culling Grinder culls the weak!");
		for(Schmuck e : bs.bp.getSelectableEnemies(s)){
			if(e.getLvl()+15<s.getLvl()){
				bs.bp.em.hpChange(-300, s, e, 6);
			}
		}
	}
}
