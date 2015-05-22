package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LifeDrain extends Skills {

	public String name = "Life Drain";	public String descr = "User sucks the lifeforce from a\ntargeted foe, dealing damage\n and restoring health.";
	public int cost = 7;
	public LifeDrain(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		bs.bp.bt.textList.add(perp.getName()+" restored Hp!");
		bs.bp.em.hpChange(-(4*perp.buffedStats[2]*perp.buffedStats[2]/5)/vic.buffedStats[3],vic);
		bs.bp.em.hpChange((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),perp);
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public int getCost(){
		return cost;
	}
	

}
