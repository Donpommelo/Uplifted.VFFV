package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoubleGeneva extends Skills {

	public static String name = "Double Geneva";
	public static String descr = "User fires a one-two punch of magical missiles that strike random enemies.";
	public static String descrShort = "Damages two random foes.\nScales to Int. ";
	public static int cost = 15;
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
		
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
		int damage1 = (int)(bs.bp.em.logScaleDamage(perp, target1) * 0.75);
		bs.bp.em.hpChange(damage1, perp, target1,6);
		
		int damage2 = (int)(bs.bp.em.logScaleDamage(perp, target2) * 0.75);
		bs.bp.em.hpChange(damage2, perp, target2,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		
		int damage1 = (int)(bs.bp.em.logScaleDamage(perp, target1)*(1.5+perp.getCritMulti()-target1.getCritRes()) * 0.75);
		bs.bp.em.hpChange(damage1, perp, target1,6);
		
		int damage2 = (int)(bs.bp.em.logScaleDamage(perp, target2)*(1.5+perp.getCritMulti()-target2.getCritRes()) * 0.75);
		bs.bp.em.hpChange(damage2, perp, target2,6);
	}
	
}
