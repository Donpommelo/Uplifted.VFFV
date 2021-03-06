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
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,1);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,1);
	}
		
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" attacks "+vic.getName()+" again!";
	}
		
}
