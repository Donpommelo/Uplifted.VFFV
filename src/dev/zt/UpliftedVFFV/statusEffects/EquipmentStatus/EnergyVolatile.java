package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EnergyVolatile extends status{
	
	public EnergyVolatile(Schmuck v,int pr){
		super("Volatile (Energy Source)", v,pr);
	}
	
	public int spendMeterEffect(Schmuck s, BattleState bs, int mp){
		bs.bp.bt.addScene(s.getName()+"'s Energy Source radiates with excess Power!");
		bs.bp.em.hpChange((int)(mp/2 * (1 - s.getEquipPow())), s, s, 3);
		return mp;
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[35] += (.30 * s.getMaxBp() * (1 + s.getEquipPow())*(1+s.getRegenBonus()));
	}
}
