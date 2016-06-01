package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class HeresHow extends Skills {

	public static String name = "Here's How";
	public static String descr = "User shows an ally all the ways they were doing everything wrong, giving them another opportunity to finally get it right.";
	public static String descrShort = "Gives turn to ally.";
	public static int cost = 20;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public HeresHow(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(vic.getName()+" gains an additional turn!");
		bs.bp.TurnOrderQueue.add(new Action(vic,vic,new ExtraTurn(0),bs));
	}
		
	public boolean startTarget(){
		return true;
	}
}
