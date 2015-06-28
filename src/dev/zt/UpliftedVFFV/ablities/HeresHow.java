package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class HeresHow extends Skills {

	public String name = "Here's How";
	public String descr = "User shows an ally the right\nway of doing things, giving\nthem an extra turn.";
	public String descrShort = "Gives turn to ally.";
	public int cost = 10;
	public HeresHow(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Here's How!");
		bs.bp.bt.textList.add(vic.getName()+" gains an additional turn!");
		bs.bp.TurnOrderQueue.add(new Action(vic,vic,new DillyDally(0),bs));
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
	
	public boolean startTarget(){
		return true;
	}

}
