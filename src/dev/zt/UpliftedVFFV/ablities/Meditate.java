package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Channeling;
import dev.zt.UpliftedVFFV.statusEffects.Invisible;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.MeditateEffect;

public class Meditate extends Skills {

	public static String name = "Meditate";
	public static String descr = "User focuses chi contemplates the universe. If left unchecked, this ability will regenerate large amounts of health.";
	public static String descrShort = "Delayed, interruptable self-healing.";
	public static int cost = 11;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 1;	//No Target
	public Meditate(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		status st = new MeditateEffect(0,perp, perp, 50);
		bs.bp.stm.addStatus(perp, st);
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/5,8,st,false,false,true,perp,perp,perp,50));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(a);
	}

}
