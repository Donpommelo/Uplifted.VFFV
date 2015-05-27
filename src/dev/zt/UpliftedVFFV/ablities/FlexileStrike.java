package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public String name = "Flexile Strike";
	public String descr = "User attacks multiple enemy\nwith a flexible appendage.";
	public String descrShort = "Damages two random\nenemies.";
	public int cost = 6;
	public FlexileStrike(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Flexile Strike!");
		if(bs.bp.bm.enemy.contains(vic)){
			target1 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
			target2 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
		}
		else{
			target1 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
			target2 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
		}
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)),target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*1.5)),target2);

	}
		
	public String getName(){
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	

}
