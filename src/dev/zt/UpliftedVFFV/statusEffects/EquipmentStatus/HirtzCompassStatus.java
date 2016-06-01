package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class HirtzCompassStatus extends status{

	public HirtzCompassStatus(Schmuck v,int pr){
		super("Finding Weakness", v,pr);
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		if(bs.bp.getSelectableEnemies(perp).contains(vic) && a.getSkill().targetType == 0){
			bs.bp.bt.addScene(vic.getName()+"'s Hirtz Compass finds where it really Hirtz!");
			bs.bp.stm.addStatus(vic, new BonusStatBuff(2,28,-.25*(1+perp.getEquipPow()),perp,vic,50));
			bs.bp.stm.addStatus(vic, new BonusStatBuff(2,32,-.25*(1+perp.getEquipPow()),perp,vic,50));
		}
	}
}
