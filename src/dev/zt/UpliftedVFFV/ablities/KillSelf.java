package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.KillSwitchStatus;


public class KillSelf extends Skills {

	public static String name = "Kill Self";
	public static String descr = "User incapacitates self\nbut will be revived 3 turns later.";
	public static String descrShort = "Kills user.\nRevives 3 turns later.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public KillSelf(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(perp.getName()+" presses "+perp.getPronoun(1)+" Kill Switch!");
		bs.bp.stm.addStatus(perp, new incapacitate(perp));
		bs.bp.stm.addStatus(perp, new KillSwitchStatus(0));
		perp.setCurrentHp(0);
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
