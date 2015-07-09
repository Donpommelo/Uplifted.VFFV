package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class HeresHow extends Skills {

	public static String name = "Here's How";
	public static String descr = "User shows an ally the right\nway of doing things, giving\nthem an extra turn.";
	public static String descrShort = "Gives turn to ally.";
	public static int cost = 10;
	public HeresHow(int index) {
		super(index,0,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Here's How!");
		bs.bp.bt.textList.add(vic.getName()+" gains an additional turn!");
		bs.bp.TurnOrderQueue.add(new Action(vic,vic,new DillyDally(0),bs));
	}
		
	public boolean startTarget(){
		return true;
	}

}
