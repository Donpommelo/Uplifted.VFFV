package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.InvertedSwanEffect;

public class InvertedSwan extends Skills {

	public static String name = "Inverted Swan";
	public static String descr = "User infuses a target\nthe grace of an upside-\nswan, granting a double\n-attack.";
	public static String descrShort = "Gives a Double-Attack.\nThe second hit is Blue\naligned.";
	public static int cost = 14;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public InvertedSwan(int index) {
		super(index,0,1, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Inverted Swan!");
		bs.bp.stm.addStatus(vic, new InvertedSwanEffect(1, perp, 15));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Inverted Swan!");
		bs.bp.bt.textList.add("A Critical buff!");
		bs.bp.stm.addStatus(vic, new InvertedSwanEffect((int)(1+perp.getCritMulti()), perp, 15));		
	}

	public boolean startTarget(){
		return true;
	}

}
