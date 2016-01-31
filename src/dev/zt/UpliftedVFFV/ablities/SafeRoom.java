package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;

public class SafeRoom extends Skills {

	public static String name = "Safe Room";
	public static String descr = "User banishes a target into an\n impervious box that both\nprotects and subdues the target.";
	public static String descrShort = "Banish and protect target.";
	public static int cost = 5;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public SafeRoom(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(vic.getName()+" was banished.");
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp)){
				bs.bp.TurnOrderQueue.remove(i);
				i--;
			}
		}
		bs.bp.stm.addStatus(vic, new Invuln(0, perp, 0));
	}
}
