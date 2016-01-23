package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Updraft extends Skills {

	public static String name = "Updraft";
	public static String descr = "User creates violent eind\nthat deal Yellow damage\nto slower foes.";
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
					bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(a.user.buffedStats[3]), perp, a.user,3);
				}
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Action a : bs.bp.TurnOrderQueue){
			if(a != null){
				if(bs.bp.getSelectableEnemies(perp).contains(a.user)){
					bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*3)/(a.user.buffedStats[3]*2), perp, a.user,3);
				}
			}
		}
	}
		
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*5),perp,s,6,1000);
		}
		return damage;
	}
	
	
}
