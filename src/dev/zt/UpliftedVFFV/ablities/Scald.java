package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;


public class Scald extends Skills {

	public static String name = "Scald";
	public static String descr = "A spray of boiling hot liquid that\ncan inflict nasty burns.";
	public static String descrShort = "Deals Red Damage and\ndegenerates Hp.";
	public static int cost = 5;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public Scald(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,0);
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,34,-4,perp,50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,0);
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,34,-6,perp,50));
	}
}
