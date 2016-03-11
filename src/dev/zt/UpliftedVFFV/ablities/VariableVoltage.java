package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class VariableVoltage extends Skills {

	public static String name = "Variable Voltage";
	public static String descr = "User strikes the enemy team with random bursts of electricity.";
	public static String descrShort = "Deals random Yellow damage to enemies.";
	public static int cost = 22;
	public static int baseAcc = 100; public static int baseCrit = 10;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//No Target
	public VariableVoltage(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int numtargets = (int)(Math.random()*5);
		for(int i = 0; i < numtargets; i++){
			Schmuck target;
			target = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
			int damage = (int)(Math.random() * (bs.bp.em.logScaleDamage(perp, target)));
			bs.bp.em.hpChange(damage, perp, target,3);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int numtargets = (int)(Math.random()*8);
		for(int i = 0; i < numtargets; i++){
			Schmuck target;
			target = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
			int damage = (int)(bs.bp.em.logScaleDamage(perp, target)*(1.5+perp.getCritMulti()-target.getCritRes()));
			bs.bp.em.hpChange(damage, perp, target,6);
		}
	}
				
}
