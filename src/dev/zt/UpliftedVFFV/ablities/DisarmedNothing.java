package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DisarmedNothing extends Skills {
	
public Item thing;

	public DisarmedNothing(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" tried to use attack, but was Disarmed.");
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

}
