package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Intimidated;


public class ScaryFace extends Skills {

	public static String name = "Scary Face";
	public static String descr = "User flashes an intimidating face,\n making them likely to flinch.";
	public static String descrShort = "Intimidates target.";
	public static int cost = 7;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ScaryFace(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new Intimidated(3, 40));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Intimidated((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), 40));	
	}
}
