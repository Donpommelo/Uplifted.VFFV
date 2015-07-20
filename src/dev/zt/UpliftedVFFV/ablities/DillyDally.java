package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class DillyDally extends Skills {

	public static String name = "Dilly Dally";
	public static String descr = "User waits.";
	public static String descrShort = "Delays decision making.";
	public static int cost = 0;
	public DillyDally(int index) {
		super(index, 1, 6, name, descr, descrShort, cost, Assets.wait);
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

}
