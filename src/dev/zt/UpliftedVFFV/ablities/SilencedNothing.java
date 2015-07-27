package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class SilencedNothing extends Skills {
	
public Item thing;
	public String moveReplaced;
	public SilencedNothing(int index, String moveReplaced) {
	super(index,1,6,"","","", 0, 0,0, false, false);
	this.moveReplaced = moveReplaced;
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" tried to use "+moveReplaced+" but was Silenced.");
	}
}
