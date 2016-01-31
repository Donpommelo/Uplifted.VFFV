package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Channeling;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.WindUpPunchEffect;

public class WindUpPunch extends Skills {

	public static String name = "Wind-Up Punch";
	public static String descr = "Winds up and unleashes a powerful blow\nat the end of the round./Interrupted by damage./";
	public static String descrShort = "Powerful, interruptable\nattack at end of round.";
	public static int cost = 11;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public WindUpPunch(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		status st = new WindUpPunchEffect(0,perp,vic, 50);
		bs.bp.stm.addStatus(perp, st);
		bs.bp.stm.addStatus(perp, new Channeling(1,10,st,false,true,true,perp,perp,50));
	}

}
