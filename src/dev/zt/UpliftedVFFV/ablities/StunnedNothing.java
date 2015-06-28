package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StunnedNothing extends Skills {
	
public Item thing;

	public StunnedNothing(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" is Stunned and cannot move.");
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

}
