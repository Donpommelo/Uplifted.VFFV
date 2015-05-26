package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class VariableVoltage extends Skills {

	public String name = "Variable Voltage";
	public String descr = "User strikes the enemy team\nwith random bursts of\nelectricity.";
	public String descrShort = "Deals random Yellow\ndamage to enemies.";
	public int cost = 15;
	public VariableVoltage(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		bs.bp.bt.textList.add(perp.getName()+" used Variable Voltage!");
		if(bs.bp.bm.enemy.contains(vic)){
			target1 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
			target2 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
			target3 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
		}
		else{
			target1 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
			target2 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
			target3 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
		}
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3])),target1,3);
		if(target1.equals(target2)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)),target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*4)),target3,3);
			}
			else{
				if(target1.equals(target3)){
					bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)),target3,3);
				}
			}
		}
		else{
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)),target3,3);
			}
			else{
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),target2,3);
			}
		}
		

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
