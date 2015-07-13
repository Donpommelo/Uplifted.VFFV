package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class RunawayNothing extends Skills {
	
public Item thing;
	public String moveReplaced;
	public RunawayNothing(int index) {
	super(index,1,6,"","","",0);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" tried to use run but was pursued.");
	}

}
