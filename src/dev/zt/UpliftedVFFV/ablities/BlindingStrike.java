package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class BlindingStrike extends Skills {

	public static String name = "Blinding Strike";
	public static String descr = "User strikes at a foe's eyes,\npotentially blinding them.";
	public static String descrShort = "Damages and blinds target.";
	public static int cost = 5;
	public static int baseAcc = 90; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public BlindingStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Blinding Strike!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3],perp,vic,6);
		bs.bp.stm.addStatus(vic, new Blind(3, perp, 40));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Blinding Strike!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,6);
		bs.bp.stm.addStatus(vic, new Blind((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, 80));	
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,90);
	}
}