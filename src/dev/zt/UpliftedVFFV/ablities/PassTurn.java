package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PassTurn extends Skills {
	
public Item thing;


	public static String name = "Pass Turn";
	public static String descr = "User contemplates life.";
	public static String descrShort = "Skips turn.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public PassTurn(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, 2, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" does absolutely nothing.");
	}
	
}
