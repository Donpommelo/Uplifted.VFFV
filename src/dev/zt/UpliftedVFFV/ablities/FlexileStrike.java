package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public static String name = "Flexile Strike";
	public static String descr = "User attacks multiple enemy\nwith a flexible appendage.";
	public static String descrShort = "Damages two random\nenemies.";
	public static int cost = 6;
	public FlexileStrike(int index) {
		super(index,1,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Flexile Strike!");
		
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
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
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target3 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target4 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2.5)), perp, target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*1.5)), perp, target3);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])), perp, target4);
				
	}
		
	public int getTargetType(){
		return targetType;
	}
	

}
