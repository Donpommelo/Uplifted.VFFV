package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public static String name = "Doors of Closure";
	public static String descr = "User summons a pair of sliding doors to close violently on enemies. This slow attack strikes all foes with physical damage.";
	public static String descrShort = "Damages all enemies.\nLoses initiative";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public DoorsofClosure(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.9);
			bs.bp.em.hpChange(damage, perp, s,6);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			int damage = (int)(bs.bp.em.logScaleDamage(perp, s)*(1.5+perp.getCritMulti()-s.getCritRes()) * 0.8);
			bs.bp.em.hpChange(damage, perp, s,6);
		}		
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(a);
	}	
}
