package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class MotorGrinder extends Skills {

	public static String name = "Motorgrinder";
	public static String descr = "User summons crushing gears to\nbatter a foe and lower the\ntarget's Defense.";
	public static String descrShort = "Damage and lower Def.";
	public static int cost = 13;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public MotorGrinder(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new StatBuffMult(2,3,.8, perp,60));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new StatBuffMult(2,3,.8*(1+perp.getCritMulti()-vic.getCritRes()), perp,60));
	}
	
}
