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
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public DamnedDescent(int index) {
		super(index, element, targetType, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*1.5), perp, vic,0);
		if(vic.tempStats[0]==0){
			bs.bp.bt.addScene(perp.getName()+" claims "+vic.getName()+"'s soul!");
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]), perp, vic,0);
		if(vic.tempStats[0]==0){
			bs.bp.bt.addScene(perp.getName()+" claims "+vic.getName()+"'s soul!");
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
			bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
		}	
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*1.5));
		return bs.bp.em.damageSimulation(damage, perp, vic, 0,80);
	}
}
