package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PennyBlueStatus;
public class PennyBlue extends Skills {

	public static String name = "Penny Blue";
	public static String descr = "User grants a target a\nBlue-aligned shield that\nregenerates health and\nbolsters Red resistance.";
	public static String descrShort = "Buffs Red Resist and regen.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public PennyBlue(int index) {
		super(index,0,1, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Penny Blue!");
		bs.bp.stm.addStatus(vic, new PennyBlueStatus(3, perp, 35));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Penny Blue!");
		bs.bp.bt.textList.add("A Critical buff!");
		bs.bp.stm.addStatus(vic, new PennyBlueStatus((int)(3*(1+perp.getCritMulti())), perp, 60));	
	}
	
	public boolean startTarget(){
		return true;
	}
}
