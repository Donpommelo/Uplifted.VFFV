package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DayattheFair extends Skills {

	public static String name = "Day at the Fair";
	public static String descr = "User summons a raucous parade to disturb the fight and trample foes. The ensuing confusion may cause the pensive to forget what it was they were planning on doing.";
	public static String descrShort = "Damages and ends round prematurely.";
	public static int cost = 43;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public DayattheFair(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene("The round was ended prematurely");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.5);
			bs.bp.em.hpChange(damage, perp, s,6);
		}
		bs.bp.TurnOrderQueue.clear();
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene("The round was ended prematurely");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(int)(15*(1+perp.getCritMulti()-s.getCritRes())), perp, s,6);
		}
		bs.bp.TurnOrderQueue.clear();

	}
}
