package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.InvertedSwanEffect;

public class InvertedSwan extends Skills {

	public static String name = "Inverted Swan";
	public static String descr = "User infuses a target the grace of an upside-down swan, granting a double-attack.";
	public static String descrShort = "Gives a Double-Attack.\nThe second hit is Blue aligned.";
	public static int cost = 28;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 1;	//Blue
	public static int targetType = 0;	//Any Single Target
	public InvertedSwan(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new InvertedSwanEffect(1, perp, 15));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new InvertedSwanEffect((int)(1+perp.getCritMulti()-vic.getCritRes()), perp, 15));		
	}

	public boolean startTarget(){
		return true;
	}

}
