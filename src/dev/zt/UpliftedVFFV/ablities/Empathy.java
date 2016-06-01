package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class Empathy extends Skills {

	public static String name = "Empathy";
	public static String descr = "";
	public static String descrShort = "Averages Hp with a target";
	public static int cost = 5;
	public static int baseAcc = 75; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public Empathy(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int total = perp.getCurrentHp()+vic.getCurrentHp();
		perp.setCurrentHp(total/2);
		vic.setCurrentHp(total/2);
		if(perp.getCurrentHp() > perp.getMaxHp()){
			perp.setCurrentHp(perp.getMaxHp());
		}
		if(vic.getCurrentHp() > vic.getMaxHp()){
			vic.setCurrentHp(vic.getMaxHp());
		}
	}
	
}
