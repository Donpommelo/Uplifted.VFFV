package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public String name = "Flexile Strike";
	public String descr = "User attacks multiple enemy\nwith a flexible appendage.";
	public String descrShort = "Damages two random\nenemies.";
	public int cost = 6;
	public FlexileStrike(int index) {
		super(index,1);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Flexile Strike!");
		
		target1 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target2 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp, target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*1.5)), perp, target2);

	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		Schmuck target4;
		bs.bp.bt.textList.add(perp.getName()+" used Flexile Strike!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5*perp.getCritMulti())), perp, vic);
		target1 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target2 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target3 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target4 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2.5)), perp, target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*1.5)), perp, target3);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])), perp, target4);
				
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
	
	public int getTargetType(){
		return targetType;
	}
	

}
