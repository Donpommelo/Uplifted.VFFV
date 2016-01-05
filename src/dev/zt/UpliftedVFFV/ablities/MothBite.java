package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Unresistant;

public class MothBite extends Skills {

	public static String name = "Mothbite";
	public static String descr = "User unravels a target's being\ndamaging and removing resistances.";
	public static String descrShort = "Damage and removes resistances\nfor remainder of round.";
	public static int cost = 32;
	public static int baseAcc = 75; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public MothBite(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Mothbite!");
		bs.bp.stm.addStatus(vic, new Unresistant(0, perp,50));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2), perp, vic,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Mothbite!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new Unresistant(1, perp,50));
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti()-vic.getCritRes())), perp, vic,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*2);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,80);
	}

}
