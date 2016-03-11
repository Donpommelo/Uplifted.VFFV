package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Disarmed;


public class Pacifism extends Skills {

	public static String name = "Pacifism";
	public static String descr = "User instills pacifism in a target, making them lay down their standard attacks.";
	public static String descrShort = "Inflicts Disarm on target.";
	public static int cost = 16;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Pacifism(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new Disarmed(4, perp, 50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Disarmed((int)(4*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, 50));	
	}
}
