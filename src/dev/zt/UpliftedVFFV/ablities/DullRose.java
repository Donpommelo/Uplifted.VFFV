package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.DullRoseStatus;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.SindhDakStatus;

public class DullRose extends Skills {

	public static String name = "Dull Rose";
	public static String descr = "User grants a target a living shield that disincentivize attack with rows of painful thorns.";
	public static String descrShort = "Gives damage reduction and reflection.";
	public static int cost = 31;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public DullRose(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new DullRoseStatus(3, perp, 10));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new DullRoseStatus((int)(3*(1+perp.getCritMulti())), perp, 20));	
	}
	
	public boolean startTarget(){
		return true;
	}

}
