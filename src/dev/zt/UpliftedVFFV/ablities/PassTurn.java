package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class PassTurn extends Skills {
	
public Item thing;

	public PassTurn(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
	
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" does absolutely nothing.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}

}