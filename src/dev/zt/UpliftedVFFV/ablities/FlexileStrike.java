package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public static String name = "Flexile Strike";
	public static String descr = "User utilizes a flexible appendage to strike foes multiple times.";
	public static String descrShort = "Damages two random enemies.";
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
		
		int damage1 = (int)(bs.bp.em.logScaleDamage(perp, target1) * 0.9);
		bs.bp.em.hpChange(damage1, perp, target1,6);
		
		int damage2 = (int)(bs.bp.em.logScaleDamage(perp, target2) * 0.6);
		bs.bp.em.hpChange(damage2, perp, target2,6);
		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;

		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));

		int damage1 = (int)(bs.bp.em.logScaleDamage(perp, target1)*(1.5+perp.getCritMulti()-target1.getCritRes()) * 0.9);
		bs.bp.em.hpChange(damage1, perp, target1,6);
		
		int damage2 = (int)(bs.bp.em.logScaleDamage(perp, target2)*(1.5+perp.getCritMulti()-target2.getCritRes()) * 0.6);
		bs.bp.em.hpChange(damage2, perp, target2,6);
		
	}
		
}
