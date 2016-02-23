package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class GenerateHeat extends Skills {

	public static String name = "Generate Heat";
	public static String descr = "User increases temperature, boosting\nthe Red Alignment of all allies.";
	public static String descrShort = "Raises Red Alignment of allies.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 0;	//Red
	public static int targetType = 1;	//No Target
	public GenerateHeat(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck ally : bs.bp.getSelectableAllies(perp)){
			bs.bp.stm.addStatus(ally, new ElemPointsBuff(4, 0, 15, perp, 50));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck ally : bs.bp.getSelectableAllies(perp)){
			bs.bp.stm.addStatus(ally, new ElemPointsBuff(5, 0, 25, perp, 50));
		}	
	}
}
