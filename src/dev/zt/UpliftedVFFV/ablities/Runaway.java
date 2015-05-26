package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Runaway extends Skills {

	public String name = "Run Away";
	public int cost = 0;
	public Runaway(int index) {
		super(index, Assets.run);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" ran away!");
		if(bs.runnable && Math.random()<=.6){
			bs.bp.bt.ranAway = true;
		}
		else{
			bs.bp.bt.textList.add("Runaway failed!");
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
