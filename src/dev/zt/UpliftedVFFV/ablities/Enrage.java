package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Berzerk;


public class Enrage extends Skills {

	public static String name = "Enrage";
	public static String descr = "User taps into a victim's inner frustration and anger, sending them into a fit of animalistic rage.";
	public static String descrShort = "Inflicts Berserk on target.";
	public static int cost = 16;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public Enrage(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new Berzerk(3, perp, 50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Berzerk((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, 50));	
	}
}
