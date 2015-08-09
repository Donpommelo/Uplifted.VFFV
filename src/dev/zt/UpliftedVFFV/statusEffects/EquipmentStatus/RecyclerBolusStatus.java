package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RecyclerBolusStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;	
	public RecyclerBolusStatus(Schmuck perp, int pr){
		super("Recycler Bolus Effect", false, false, perp, pr);
	}
	
	public int onHealEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(vic.getName()+"'s Recycler Bolus radiates power!");
		for(Schmuck s : bs.bp.getSelectableEnemies(vic)){
			bs.bp.em.hpChange(-damage/bs.bp.getSelectableEnemies(vic).size(), vic, s, elem);
		}
		return damage;
	}	
}
