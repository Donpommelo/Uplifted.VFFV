package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Purified;


public class ShedFlesh extends Skills {

	public static String name = "Shed Flesh";
	public static String descr = "User sheds all earthly bounds and becomes unaffected by all status.";
	public static String descrShort = "Purifies user.\nCharges : 3";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//Any Single Target
	public ShedFlesh(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(perp, new Purified(2,perp,perp,50));
		bs.bp.stm.addStatus(perp, new LimitedUse(this,2, perp, perp,50));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
