package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;

public class FiremansSwitch extends Skills {

	public static String name = "Fireman's Switch";
	public static String descr = "User releases energy from overheated machinery to unleash delayed, explosive power.";
	public static String descrShort = "Inflicts Combustibility.";
	public static int cost = 12;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public FiremansSwitch(int index) {
		super(index, element, targetType, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
	
		bs.bp.stm.addStatus(vic, new Combustibility(3, perp, 40));

	}
		
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Combustibility(5, perp, 40));
	}	
}
