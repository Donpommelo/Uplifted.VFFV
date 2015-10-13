package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlavorNothing extends Skills {
	
public Item thing;

	String flavorText = "";
	public FlavorNothing(int index, String text) {
		super(index,1,6, "", "", "", 0,0,0,false,false);
		flavorText = text;
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(flavorText);
	}
	
}
