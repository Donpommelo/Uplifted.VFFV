package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class DillyDally extends Skills {

	public static String name = "Dilly Dally";
	public static String descr = "User waits.";
	public static String descrShort = "Delays decision making.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public static int iconIndex = 3;
	public static boolean canMiss = false; public static boolean canCrit = false;
	
	public DillyDally(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, iconIndex, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
	
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "DillyDally";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public void TOQChange(Action a, BattleState bs){
//		bs.bp.TurnOrderQueue.remove(a);
//		bs.bp.TurnOrderQueue.add(a);
		int meep = bs.bp.TurnOrderQueue.indexOf(a);
		if(meep < bs.bp.TurnOrderQueue.size()-2){	
			bs.bp.TurnOrderQueue.remove(a);
			bs.bp.TurnOrderQueue.add(meep+2,a);
		}

	}
	
	public boolean silenceBlocked(){
		return false;
	}

}
