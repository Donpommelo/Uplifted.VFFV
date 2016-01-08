package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MeterShield extends status{
	
	public double percent;	
	public MeterShield(double percent, int pr){
		super("Meter Shield", pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Faraday Cage absorbs damage!");
		bs.bp.em.bpChange((int)(damage*percent),vic);
		return (int)(damage *(1-percent));
	}	
}
