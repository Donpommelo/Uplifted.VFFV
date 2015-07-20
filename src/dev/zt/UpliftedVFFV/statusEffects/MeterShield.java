package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MeterShield extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;	
	public MeterShield(double percent, Schmuck perp){
		super("Meter Shield", false, false, perp);
		this.percent = percent;
	}

	public void statchanges(Schmuck s){
		s.bonusStats[8]+=percent;

	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(vic.getName()+"'s Faraday Cage absorbs damage!");
		bs.bp.em.bpChange((int)(damage*percent),vic);
		return (int)(damage *(1-percent));
	}	
}
