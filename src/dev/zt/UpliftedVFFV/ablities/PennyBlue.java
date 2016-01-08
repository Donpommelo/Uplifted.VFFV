package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.PennyBlueStatus;
public class PennyBlue extends Skills {

	public static String name = "Penny Blue";
	public static String descr = "User grants a target a\nBlue-aligned shield that\nregenerates health and\nbolsters Red resistance.";
	public static String descrShort = "Heals and boosts Mp regeneration.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 1;	//Blue
	public static int targetType = 0;	//Any Single Target
	public PennyBlue(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange((int)(perp.getBuffedInt()*(1+perp.getHealPower())), perp, vic, 1);
		bs.bp.stm.addStatus(vic, new PennyBlueStatus(3, perp, 35));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(1.5*perp.getBuffedInt()*(1+perp.getHealPower())), perp, vic, 1);
		bs.bp.stm.addStatus(vic, new PennyBlueStatus((int)(3*(1+perp.getCritMulti()-vic.getCritRes())), perp, 60));	
	}
	
	public boolean startTarget(){
		return true;
	}
}
