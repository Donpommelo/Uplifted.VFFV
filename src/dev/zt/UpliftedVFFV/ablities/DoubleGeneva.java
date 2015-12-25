package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoubleGeneva extends Skills {

	public static String name = "Double Geneva";
	public static String descr = "User summons a barrage of\nmissles that damage enemies and scale to Int.";
	public static String descrShort = "Damages two random foes.\nScales to Int. ";
	public static int cost = 12;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public DoubleGeneva(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Double Geneva!");
		
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
		bs.bp.em.hpChange(-(perp.buffedStats[6]*perp.buffedStats[6])/((int)(target1.buffedStats[3]*1.75)), perp, target1,6);
		bs.bp.em.hpChange(-(perp.buffedStats[6]*perp.buffedStats[6])/((int)(target2.buffedStats[3]*1.75)), perp, target2,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Double Geneva!");
		bs.bp.bt.textList.add("A Critical blow!");
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
		bs.bp.em.hpChange(-(perp.buffedStats[6]*perp.buffedStats[6])/((int)(target1.buffedStats[3]*.75)), perp, target1,6);
		bs.bp.em.hpChange(-(perp.buffedStats[6]*perp.buffedStats[6])/((int)(target2.buffedStats[3]*.75)), perp, target2,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		Schmuck target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		Schmuck target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp, target1, 6, 1000);
		damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp, target2, 6, 1000);
		return damage;
	}
}
