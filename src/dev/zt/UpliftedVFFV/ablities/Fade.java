package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;

public class Fade extends Skills {

	public static String name = "Fade";
	public static String descr = "User fades from existance\n becomming untargetable.";
	public static String descrShort = "User becomes untargetable.";
	public static int cost = 8;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Fade(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Fade!");
		bs.bp.stm.addStatus(perp, new Untouchable(2, perp, 50));

	}
		
}
