package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class OutofUsesNothing extends Skills {
	
public Item thing;
	public Skills move;;
	public OutofUsesNothing(int index, Skills move) {
	super(index);
	this.move = move;
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+"'s "+move.getName()+" has no more uses left!");
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

}
