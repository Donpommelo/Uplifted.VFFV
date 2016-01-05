package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class CleansingSpray extends Skills {

	public static String name = "Cleansing Spray";
	public static String descr = "User douses a target in/caustic detergent./";
	public static String descrShort = "Silences target.";
	public static int cost = 28;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public CleansingSpray(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Cleansing Spray!");
		int statusesRemoved = 0;
		for(status st : vic.statuses){
			if(!st.perm){
				statusesRemoved++;
				bs.bp.stm.removeStatus(vic, st);
			}
		}
		bs.bp.em.hpChange(-(perp.getBuffedPow()*perp.getBuffedPow()*statusesRemoved/vic.getBuffedDef()*5), perp, vic,6);
	}
}
