package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Channeling;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.Unresistant;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;


public class LockOn extends Skills {

	public static String name = "Lock On";
	public static String descr = "User Locks onto a target,\nincreasing vulnerable until\ninterrupted.";
	public static String descrShort = "Increases target's Crit\nVulnerability. Interruptable.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public LockOn(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		status st = new BonusStatBuff(32,-.5,50);
		bs.bp.stm.addStatus(vic, st);
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/4,15,st,false,false,true,perp,vic,50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		status st = new BonusStatBuff(32,-.5,50);
		bs.bp.stm.addStatus(vic, st);
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/2,15,st,false,false,true,perp,vic,50));
	}
}
