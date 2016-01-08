package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public static String name = "Flexile Strike";
	public static String descr = "User attacks multiple enemy\nwith a flexible appendage.";
	public static String descrShort = "Damages two random\nenemies.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public FlexileStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp, target1,6);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*1.5)), perp, target2,6);

	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		Schmuck target4;

		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target3 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target4 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2.5)), perp, target1,6);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2,6);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*1.5)), perp, target3,6);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])), perp, target4,6);
				
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		Schmuck target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		Schmuck target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp, target1, 6, 1000);
		damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*1.5)), perp, target2, 6, 1000);
		return damage;
	}
	
}
