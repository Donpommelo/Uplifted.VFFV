package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EnergyOvercharged extends status{
	
	public EnergyOvercharged(Schmuck v,int pr){
		super("Overcharged", v,pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Energy Source is leaking Power!");
		bs.bp.em.bpChange(damage/2, vic);
		return damage;
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[35] += (.20 * s.getMaxBp() * (1 + s.getEquipPow())*(1+s.getRegenBonus()));
	}
}
