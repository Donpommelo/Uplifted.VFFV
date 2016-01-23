package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class Swarm extends Skills {

	public static String name = "Swarm";
	public static String descr = "User incites a swarm amongst allies,\nincreasing the team's Speed.";
	public static String descrShort = "Raises Spd of allies.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Swarm(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck ally : bs.bp.getSelectableAllies(perp)){
			bs.bp.stm.addStatus(ally, new StatBuffMult(2, 4, 1.25, perp, 50));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck ally : bs.bp.getSelectableAllies(perp)){
			bs.bp.stm.addStatus(ally, new StatBuffMult(2, 4, 1.75, perp, 50));
		}	
	}
}
