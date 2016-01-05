package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;


public class Deafen extends Skills {

	public static String name = "Deafen";
	public static String descr = "User emits loud noise\nsilencing all characters.";
	public static String descrShort = "Silences all characters.";
	public static int cost = 25;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Deafen(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Deafen!");
		for(Schmuck s : bs.bp.battlers){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(perp))){
				bs.bp.stm.addStatus(s, new Silenced(3, perp, 50));
			}
		}
	}

}
