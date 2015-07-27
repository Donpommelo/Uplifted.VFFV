package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;


public class Censor extends Skills {

	public static String name = "Censor";
	public static String descr = "User harshly Censors a for, causing\nthem to be unable to cast\nspecial abilities.";
	public static String descrShort = "Silences target.";
	public static int cost = 10;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public Censor(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Censor!");
		bs.bp.stm.addStatus(vic, new Silenced(3, perp, 50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Censor!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new Silenced((int)(3*(1.5+perp.getCritMulti())), perp, 50));	
	}
}
