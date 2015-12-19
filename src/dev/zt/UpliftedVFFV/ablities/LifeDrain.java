package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LifeDrain extends Skills {

	public static String name = "Life Drain";
	public static String descr = "User sucks the lifeforce from a\ntargeted foe, dealing damage\n and restoring health.";
	public static String descrShort = "Damages target and heals\nself.";
	public static int cost = 7;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public LifeDrain(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		int damage = -(4*perp.buffedStats[2]*perp.buffedStats[2]/5)/vic.buffedStats[3];
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		bs.bp.bt.textList.add("A Critical blow!");
		int damage = -(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.2*perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2]*4)/(int)(vic.buffedStats[3]*5);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
}
