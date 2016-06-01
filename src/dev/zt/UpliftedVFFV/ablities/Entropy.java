package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.HealBlock;


public class Entropy extends Skills {

	public static String name = "Entropy";
	public static String descr = "User makes a victim succumb to decay, nullifying most attempts of regeneration life.";
	public static String descrShort = "Heal-blocks target.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Entropy(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new HealBlock(3, perp, vic,100));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new HealBlock((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic, 100));	
	}
}
