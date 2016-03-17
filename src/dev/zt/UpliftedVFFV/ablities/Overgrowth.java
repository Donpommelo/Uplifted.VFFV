package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class Overgrowth extends Skills {

	public static String name = "Overgrowth";
	public static String descr = "TEMP";
	public static String descrShort = "Deals Green damage to all other characters";
	public static int cost = 25;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 2;	//Green
	public static int targetType = 1;	//No Target
	public Overgrowth(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.battlers){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s,s))){
				if(s != perp){
					int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 1.5);
					bs.bp.em.hpChange(damage, perp, s,2);
				}
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.battlers){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s,s))){
				if(s != perp){
					int damage = (int)(bs.bp.em.logScaleDamage(perp, s)*(1.5+perp.getCritMulti()-s.getCritRes()) * 1.5);
					bs.bp.em.hpChange(damage, perp, s,2);
				}
			}
		}
	}	
}
