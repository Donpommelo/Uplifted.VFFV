package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class ExplosiveCrit extends status{

	public int damage;
	public ExplosiveCrit(int damage, int pr){
		super("Explosive Crits", pr);
		this.damage = damage;
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		for(Schmuck s : bs.bs.enemySelectable){
			bs.bp.em.hpChange(-(int)(damage * (1 + perp.getEquipPow())), perp, s,0);
		}
	}
}
