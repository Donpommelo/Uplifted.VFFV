package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class BrainScrambler extends Skills {

	public static String name = "Brain Scramble";
	public static String descr = "User batters a foe's skull/making them a little less intellectually/inclined./";
	public static String descrShort = "Damage and lower Purple Alignment.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public BrainScrambler(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Brain Scrambler!");
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(3,-12,4, perp,50));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]), perp, vic,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Brain Scrambler!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(3,-24,4, perp,50));
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti()-vic.getCritRes())), perp, vic,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*2);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,80);
	}

}
