package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BalancedStats;


public class Reorganize extends Skills {

	public static String name = "Reorganize";
	public static String descr = "TEMP";
	public static String descrShort = "Equalize target's stats.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 0;	//Any Single Target
	public Reorganize(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new BalancedStats(3, perp, vic,100));
	}

}
