package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EnergyObsolete extends status{
	
	public EnergyObsolete(Schmuck v,int pr){
		super("Exhaustible", v, pr);
	}

	public int gainMeterEffect(Schmuck s, BattleState bs, int mp){
		bs.bp.bt.addScene(s.getName()+"'s Energy Source is not compatible with this source of Power!");
		return 0;
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[35] = (.15 * s.getMaxBp() * (1 + s.getEquipPow())*(1+s.getRegenBonus()));
	}
}
