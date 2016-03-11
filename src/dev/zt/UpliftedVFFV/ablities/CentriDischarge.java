package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class CentriDischarge extends Skills {

	public static String name = "Centrifuge Discharge";
	public static String descr = "User generates rapid rotational movement to damage a victim. This ability leaves its user with long-lasting improvements in agility.";
	public static String descrShort = "Deals Yellow damage and buffs Spd.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 3;	//Yellow
	public static int targetType = 0;	//Any Single Target
	public CentriDischarge(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,3);
		bs.bp.stm.addStatus(perp, new StatBuffMult(5,4,1.25, perp,75));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,3);
		bs.bp.stm.addStatus(perp, new StatBuffMult(5,4,2, perp,25));	
	}
}
