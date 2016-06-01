package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;


public class GodsBreath extends Skills {

	public static String name = "Gods Breath";
	public static String descr = "User infuses allies with divine aether, rendering them temporarily protected from immediate harm.\nLimit : One use per fight.";
	public static String descrShort = "Protects all allies Charges : 1";
	public static int cost = 15;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//No Target
	public GodsBreath(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene("All allies were fortified!");
			bs.bp.stm.addStatus(perp, new LimitedUse(this,0, perp,perp, 50));
			for(Schmuck s : bs.bp.getSelectableAllies(perp)){
				bs.bp.stm.addStatus(s, new Invuln(0, perp, s,100));
			}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
