package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class ActuallyNothing extends Skills {
	
public Item thing;

	public ActuallyNothing(int index) {
		super(index, 1,6, "", "", "", 0,0,0,false,false);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
	
	}
	
	public boolean useName(){
		return false;
	}
	
}
