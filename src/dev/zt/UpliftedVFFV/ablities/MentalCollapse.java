package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MentalCollapse extends Skills {

	public static String name = "Mental Collapse";
	public static String descr = "TEMP";
	public static String descrShort = "Deals Purple damage to target's team scaling to target's Int.";
	public static int cost = 17;
	public static int baseAcc = 90; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 4;	//Purple
	public static int targetType = 0;	//Any Single Target
	public MentalCollapse(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			int damage = (int)(vic.getBuffedInt() * 1.5);
			bs.bp.em.hpChange(damage, perp, s,4);	
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			int damage = (int)(vic.getBuffedInt() * 1.5*(1.5+perp.getCritMulti()-vic.getCritRes()));
			bs.bp.em.hpChange(damage, perp, s,4);	
		}
	}
}
