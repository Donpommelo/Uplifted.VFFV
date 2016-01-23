package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DrownOut extends Skills {

	public static String name = "Drown Out";
	public static String descr = "User floods a foe with terrible\nnoise.";
	public static String descrShort = "Deals Blue damage.\nCan be used when Silenced";
	public static int cost = 5;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 1;	//Blue
	public static int targetType = 0;	//Any Single Target
	public DrownOut(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.6))/vic.buffedStats[3],perp, vic,1);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2]*.6)/vic.buffedStats[3])*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,1);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.6))/vic.buffedStats[3];
		return bs.bp.em.damageSimulation(damage, perp, vic, 3,100);
	}

	public boolean silenceBlocked(){
		return false;
	}
	
}
