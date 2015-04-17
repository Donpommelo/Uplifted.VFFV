package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.GameState;

public class ItemNothing extends Skills {
	
public Item thing;
public GameState gs;
	public ItemNothing(int index, Item i, GameState gs) {
		super(index);
		this.thing=i;
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic){
		
		}
	

}
