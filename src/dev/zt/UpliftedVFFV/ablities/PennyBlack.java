package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.PennyBlackStatus;

public class PennyBlack extends Skills {

	public static String name = "Penny Black";
	public static String descr = "User grants a target a mysterious shield that instills unease in enemies.";
	public static String descrShort = "Grants Void-bonus damage.";
	public static int cost = 48;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 5;	//Void
	public static int targetType = 0;	//Any Single Target
	public PennyBlack(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new PennyBlackStatus(3, perp, vic, 20));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new PennyBlackStatus((int)(3*(1+perp.getCritMulti()-vic.getCritRes())), perp,vic, 20));	
	}
	
	public boolean startTarget(){
		return true;
	}

}
