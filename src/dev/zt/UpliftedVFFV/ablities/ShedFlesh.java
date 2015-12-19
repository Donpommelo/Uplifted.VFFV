package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Purified;


public class ShedFlesh extends Skills {

	public static String name = "Shed Flesh";
	public static String descr = "User sheds all earthly bounds and\n becomes unaffected by all status.";
	public static String descrShort = "Purifies user.\n1 use per fight.";
	public static int cost = 10;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//Any Single Target
	public ShedFlesh(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Shed Flesh!");
		bs.bp.bt.textList.add(perp.getName()+" was Purified");
		bs.bp.stm.addStatus(perp, new LimitedUse(this,0, perp, 50));
		bs.bp.stm.addStatus(perp, new Purified(3,perp,50));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
