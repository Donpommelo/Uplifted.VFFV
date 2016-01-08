package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class CentriDischarge extends Skills {

	public static String name = "Centrifuge Discharge";
	public static String descr = "User generates rapid movement\nthat damages an enemy while\nbuffing Speed";
	public static String descrShort = "Deals Yellow damage and\nbuffs Spd.";
	public static int cost = 9;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 3;	//Yellow
	public static int targetType = 0;	//Any Single Target
	public CentriDischarge(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,3);
		bs.bp.stm.addStatus(perp, new TestStatBuff(3,4,1.5, perp,75));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-(int)((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,3);
		bs.bp.stm.addStatus(perp, new TestStatBuff(3,4,2, perp,25));	
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 3,100);
	}
}
