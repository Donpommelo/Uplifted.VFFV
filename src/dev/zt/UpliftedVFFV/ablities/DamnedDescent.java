package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class DamnedDescent extends Skills {

	public static String name = "Damned Descent";
	public static String descr = "User drops a target a considerable\ndistance. If this attack\nincapacitates a foe, the\nuser gains an extra turn.";
	public static String descrShort = "Deals Red damage and\nrefunds turn if lethal.";
	public static int cost = 11;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public DamnedDescent(int index) {
		super(index,0,0, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Damned Descent!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*1.5), perp, vic,0);
		if(vic.tempStats[0]==0){
			bs.bp.bt.textList.add(perp.getName()+"'s sin is repaid!");
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Damned Descent!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]), perp, vic,0);
		if(vic.tempStats[0]==0){
			bs.bp.bt.textList.add(perp.getName()+"'s sin is repaid!");
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
		}	
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*1.5));
		return bs.bp.em.damageSimulation(damage, perp, vic, 0,80);
	}
}
