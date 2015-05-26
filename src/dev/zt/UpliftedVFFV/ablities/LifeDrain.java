package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LifeDrain extends Skills {

	public String name = "Life Drain";
	public String descr = "User sucks the lifeforce from a\ntargeted foe, dealing damage\n and restoring health.";
	public String descrShort = "Damages target and heals\nself.";
	public int cost = 7;
	public LifeDrain(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(4*perp.buffedStats[2]*perp.buffedStats[2]/5)/vic.buffedStats[3],vic);
			bs.bp.em.hpChange((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),perp);
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	

}
