package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.PantherPoiseEffect;

public class PantherPoise extends Skills {

	public static String name = "Panther Poise";
	public static String descr = "User gains the poise of a\npanther and gets ready to do\npanther things.";
	public static String descrShort = "Redirects items to self.";
	public static int cost = 8;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public PantherPoise(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Panther Poise!");
		bs.bp.bt.textList.add(perp.getName()+" looks poised to strike!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.stm.addStatus(s, new PantherPoiseEffect(1,perp, 90));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Panther Poise!");
		bs.bp.bt.textList.add(perp.getName()+" looks critically poised to strike!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.stm.addStatus(s, new PantherPoiseEffect((int)(1.5+perp.getCritMulti()-s.getCritRes()),perp, 90));
		}
	}
}
