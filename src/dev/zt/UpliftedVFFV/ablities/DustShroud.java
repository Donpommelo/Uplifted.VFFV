package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Invisible;


public class DustShroud extends Skills {

	public static String name = "Dust Shroud";
	public static String descr = "User summons a blinding cloud that renders\nall teamates untargetable.";
	public static String descrShort = "Makes allies untargetable\n1 use per fight.";
	public static int cost = 10;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 2;	//Green
	public static int targetType = 1;	//No Target
	public DustShroud(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene("All allies became Untargetable!");
			bs.bp.stm.addStatus(perp, new LimitedUse(this,0, perp, 50));
			for(Schmuck s : bs.bp.getSelectableAllies(perp)){
				bs.bp.stm.addStatus(s, new Invisible(2, perp, 50));
			}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
