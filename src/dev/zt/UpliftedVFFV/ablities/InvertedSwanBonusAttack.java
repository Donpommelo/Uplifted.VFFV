package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class InvertedSwanBonusAttack extends Skills {

	
	public static String name = "Extra Attack";
	public static String descr = "User attacks a foe.";
	public static String descrShort = "Deals damage target.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 1;	//Blue
	public static int targetType = 0;	//Any Single Target
	public InvertedSwanBonusAttack(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+" again!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,1);		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+" again!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,1);		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		int damage = -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
}
