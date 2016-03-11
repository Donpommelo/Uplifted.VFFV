package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Stall extends Skills {

	public static String name = "Stall";
	public static String descr = "User stalls, doing nothing but wasting time.";
	public static String descrShort = "Add 3 null actions to Action Queue.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Stall(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(vic.getName()+" is Stalling for time!");
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,"Ok. I think that's enough stalling for now."),bs));
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,perp.getName()+" is still Stalling!"),bs));
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,perp.getName()+" continues to Stall for time!"),bs));

	}
}
