package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class MotorGrinder extends Skills {

	public static String name = "Motorgrinder";
	public static String descr = "User summons crushing gears to\nbatter a foe and lower the\ntarget's Defense.";
	public static String descrShort = "Damage and lower Def.";
	public static int cost = 7;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public MotorGrinder(int index) {
		super(index,0,6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Motorgrinder!");
		bs.bp.stm.addStatus(vic, new TestStatBuff(2,3,.8, perp,60));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2), perp, vic,6);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Motorgrinder!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new TestStatBuff(2,3,(int)(.8*(1-perp.getCritMulti())), perp,60));
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti())), perp, vic,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*2);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,80);
	}

}
