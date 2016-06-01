package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LifeDrain extends Skills {

	public static String name = "Life Drain";
	public static String descr = "User sucks the vitality from a targeted foe, dealing damage and restoring a comparative amount of health.";
	public static String descrShort = "Damages target and heals self.";
	public static int cost = 7;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public LifeDrain(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * 0.8);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()) * 0.8);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,6);
	}
}
