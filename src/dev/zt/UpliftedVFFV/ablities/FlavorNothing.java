package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlavorNothing extends Skills {
	
	String flavorText = "";
	public static String name = "";
	public static String descr = ".";
	public static String descrShort = "";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public FlavorNothing(int index, String text) {
		super(index, element, targetType, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
		flavorText = text;
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(flavorText);
	}
	
}