package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Updraft extends Skills {

	public static String name = "Updraft";
	public static String descr = "User creates violent wind that deal Yellow damage to slower foes.";
	public static String descrShort = "Deals Yellow damage to slower foes.";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//No Target
	public Updraft(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Action a : bs.bp.TurnOrderQueue){
			if(a != null){
				if(bs.bp.getSelectableEnemies(perp).contains(a.user)){
					int damage = (int)(bs.bp.em.logScaleDamage(perp, a.user));
					bs.bp.em.hpChange(damage, perp, a.user,3);
				}
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Action a : bs.bp.TurnOrderQueue){
			if(a != null){
				if(bs.bp.getSelectableEnemies(perp).contains(a.user)){
					int damage = (int)(bs.bp.em.logScaleDamage(perp, a.user)*(1.5+perp.getCritMulti()-a.user.getCritRes()));
					bs.bp.em.hpChange(damage, perp, a.user,3);
				}
			}
		}
	}
}
