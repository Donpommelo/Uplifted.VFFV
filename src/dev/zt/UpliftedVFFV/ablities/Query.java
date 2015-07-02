package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Queried;

public class Query extends Skills {

	public String name = "Query";
	public String descr = "User researches a foe, gaining\nvaluable knowledge about its,\nelemental alignments and Hp.";
	public String descrShort = "Investigate enemy info.";
	public int cost = 0;
	public Query(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Query!");
		bs.bp.stm.addStatus(vic, new Queried(perp));
		bs.bp.bt.textList.add("A(n) "+ vic.getName()+". "+ vic.getCurrentHp()+"/"+vic.getMaxHp()+" Hp");
		bs.bp.bt.textList.add(vic.getBio());
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
