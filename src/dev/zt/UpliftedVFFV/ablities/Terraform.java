package dev.zt.UpliftedVFFV.ablities;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Terraform extends Skills {

	public String name = "Terraform";
	public String descr = "User shakes the very foundation\nof the building, scrambling\nremaining Turn Order";
	public String descrShort = "Damages and scrambles\nTurn Order";
	public int cost = 18;
	public Terraform(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Terraform");
		bs.bp.bt.textList.add("All battlers look discombobulated.");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3])),vic);
		ArrayList<Action> temp = new ArrayList<Action>();
		bs.bp.TurnOrderQueue.remove(0);
		for(Action a : bs.bp.TurnOrderQueue){
			temp.add(a);
		}
		bs.bp.TurnOrderQueue.clear();
		while(!temp.isEmpty()){
			int rand = (int)(Math.random()*temp.size());
			bs.bp.TurnOrderQueue.add(temp.get(rand));
			temp.remove(rand);
		}
		bs.bp.TurnOrderQueue.add(0, new Action(perp, vic, new Terraform(0), bs));
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