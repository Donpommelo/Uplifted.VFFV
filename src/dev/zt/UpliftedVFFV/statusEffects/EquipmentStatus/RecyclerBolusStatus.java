package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RecyclerBolusStatus extends status{
	
	public RecyclerBolusStatus(int pr){
		super("Recycler Bolus Effect", pr);
	}
	
	public int onHealTargetEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Recycler Bolus radiates foul energy!");
		for(Schmuck s : bs.bp.getSelectableEnemies(vic)){
			damage *= (1+s.getEquipPow());
			bs.bp.em.hpChange(-damage/bs.bp.getSelectableEnemies(vic).size(), vic, s, 6);
		}
		return damage;
	}	
}
