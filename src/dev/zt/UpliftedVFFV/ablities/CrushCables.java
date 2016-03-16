package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;
import dev.zt.UpliftedVFFV.statusEffects.Paralysis;

public class CrushCables extends Skills {

	public static String name = "Crush Cable";
	public static String descr = "User summons thick cables to attack victims. Results range from flagellation to strangulation.";
	public static String descrShort = "Damages and paralyzes target.";
	public static int cost = 25;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Green
	public static int targetType = 0;	//Any Single Target
	public CrushCables(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * .75);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new Paralysis(3, perp, vic, 40));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()) * .75);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new Paralysis((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic, 80));	
	}
}
