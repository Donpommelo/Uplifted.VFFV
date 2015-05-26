package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DayattheFair extends Skills {

	public String name = "Day at the Fair";
	public String descr = "User summons a chaotic parade\nthat disturbs the fight and\nends the round.";
	public String descrShort = "Damages and ends round\nprematurely.";
	public int cost = 21;
	public DayattheFair(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Day at the Fair");
		bs.bp.bt.textList.add("The round was ended prematurely");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),vic);
		bs.bp.TurnOrderQueue.clear();
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
	

}
