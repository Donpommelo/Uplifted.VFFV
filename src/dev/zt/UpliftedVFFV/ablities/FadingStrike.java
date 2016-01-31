package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Channeling;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.FadingStrikeEffect;

public class FadingStrike extends Skills {

	public static String name = "Fading Strike";
	public static String descr = "Fade into the shadows\nto strike at a later time.";
	public static String descrShort = "Powerful, interruptable attack.\nUser becomes briefly Untargetable.";
	public static int cost = 18;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public FadingStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		status st = new FadingStrikeEffect(0,perp,vic, 50);
		bs.bp.stm.addStatus(perp, st);
		bs.bp.stm.addStatus(perp, new Untouchable(1,perp,50));
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/10,8,st,false,false,true,perp,perp,50));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(a);
	}

}
