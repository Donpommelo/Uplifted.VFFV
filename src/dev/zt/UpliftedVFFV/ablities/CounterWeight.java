package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Countered;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.PantherPoiseEffect;

public class CounterWeight extends Skills {

	public static String name = "Counterweight";
	public static String descr = "User shifts weight, preparing to retaliate to oncoming attacks with physical force.";
	public static String descrShort = "Counter enemy actions.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public CounterWeight(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(perp.getName()+" looks ready to Counter!");
		bs.bp.stm.addStatus(perp, new Countered(1,perp, perp, perp, 90));
		
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
}
