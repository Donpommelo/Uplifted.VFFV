package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class ItemNothing extends Skills {
	
public Item thing;
public GameState gs;
	public ItemNothing(int index, GameState gs) {
		super(index);
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" throws nothing at "+vic.getName();
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" doesn't seem impressed.";
	}
	

}
