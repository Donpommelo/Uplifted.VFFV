package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.GameState;

public class UseItem extends Skills {
	
public Item thing;
public GameState gs;
	public UseItem(int index, Item i, GameState gs) {
		super(index);
		this.thing=i;
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic){
		thing.use(perp,vic);
		if(thing.usedfromMenu==true){			//Replace usedfromMenu w/ consummable
			if(gs.inventorymanager.backpack.containsKey(thing)){
				int temp = gs.inventorymanager.backpack.get(thing);
				gs.inventorymanager.backpack.put(thing, temp-1);
			}
				
			
		}
		}
	public String runText(Schmuck perp, Schmuck vic){
		return "meep";
	}
	

}
