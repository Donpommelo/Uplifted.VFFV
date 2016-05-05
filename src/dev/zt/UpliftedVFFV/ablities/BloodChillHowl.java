package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class BloodChillHowl extends Skills {

	public static String name = "Bloodchill Howl";
	public static String descr = "User intimidates foe with a power-reducing howl.";
	public static String descrShort = "Lowers pow of all enemies..";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public BloodChillHowl(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.stm.addStatus(s, new StatBuffMult(5,2,.8 *(1-perp.getEquipPow()),perp,s,80));
		}
	}
}
