package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Hypochondriac;


public class Hypochondria extends Skills {

	public static String name = "Hypochondria";
	public static String descr = "User instills paranoia in the mind of foes to make illnesses seem worse.";
	public static String descrShort = "Inflicts Hypochondria.\nNegative statuses applied on target increase in duration.";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 4;	//Purple
	public static int targetType = 0;	//Any Single Target
	public Hypochondria(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new Hypochondriac(3, perp, vic, 50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Hypochondriac((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,50));	
	}
}
