package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Queried;

public class Query extends Skills {

	public static String name = "Query";
	public static String descr = "User researches a foe, gaining\nvaluable knowledge about its,\nelemental alignments and Hp.";
	public static String descrShort = "Investigate enemy info.";
	public static int cost = 0;
	public Query(int index) {
		super(index,0,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Query!");
		bs.bp.stm.addStatus(vic, new Queried(perp, 50));
		bs.bp.bt.textList.add("A(n) "+ vic.getName()+". "+ vic.getCurrentHp()+"/"+vic.getMaxHp()+" Hp");
		bs.bp.bt.textList.add(vic.getBio());
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
