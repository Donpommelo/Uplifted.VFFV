package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class ExplosiveCrit extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int damage;
	public ExplosiveCrit(int damage,Schmuck perp, int pr){
		super("Explosive Crits", false, false, perp, pr);
		this.damage = damage;
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bs.enemySelectable){
			bs.bp.em.hpChange(-damage, perp, s,0);
		}
	}
}
