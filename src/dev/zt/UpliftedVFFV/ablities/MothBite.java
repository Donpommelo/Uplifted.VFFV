package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Unresistant;

public class MothBite extends Skills {

	public static String name = "Mothbite";
	public static String descr = "User unravels the fiber of a target's being, inflicting pain and leaving its victim at the mercy of the elements.";
	public static String descrShort = "Damage and removes resistances for remainder of round.";
	public static int cost = 32;
	public static int baseAcc = 75; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public MothBite(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * 0.6);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new Unresistant(0, perp,50));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()) * 0.6);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new Unresistant(1, perp,50));
	}
}
