package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class CentriDischarge extends Skills {

	public String name = "Centrifuge Discharge";
	public String descr = "User generates rapid movement\nthat damages an enemy while\nbuffing Speed";
	public String descrShort = "Deals Yellow damage and\nbuffs Spd.";
	public int cost = 9;
	public CentriDischarge(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Centrifuge Discharge!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,3);
			bs.bp.stm.addStatus(perp, new TestStatBuff(3,4,1.2, perp));
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
