package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;


public class VoidCall extends Skills {

	public static String name = "Call Void";
	public static String descr = "TEMP";
	public static String descrShort = "Boosts target's ??? Alignment.\nCharges : 1";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 5;	//Void
	public static int targetType = 0;	//Any Single Target
	public VoidCall(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(2,5,30,perp,perp,50));
		bs.bp.stm.addStatus(perp, new LimitedUse(this,0, perp, perp,50));
	}
}
