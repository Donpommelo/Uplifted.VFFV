package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PennyBlackStatus;

public class PennyBlack extends Skills {

	public static String name = "Penny Black";
	public static String descr = "User grants a target a\nBlack-aligned shield that\nsucks away the souls of\nenemies.";
	public static String descrShort = "Grants Void-bonus damage.";
	public static int cost = 28;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public PennyBlack(int index) {
		super(index,0,5, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Penny Black!");
		bs.bp.stm.addStatus(vic, new PennyBlackStatus(3, perp, 20));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Penny Black!");
		bs.bp.bt.textList.add("A Critical buff!");
		bs.bp.stm.addStatus(vic, new PennyBlackStatus((int)(3*(1+perp.getCritMulti())), perp, 20));	
	}
	
	public boolean startTarget(){
		return true;
	}

}
