package dev.zt.UpliftedVFFV.inventory;

import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;

//This manages the player inventory
public class InventoryManager {
	
	private Game game;
	public TreeMap<Item, Integer> backpack = new TreeMap<>();			//treemap corresponding to each item and the amount owned
	
	
	public InventoryManager(Game game){
		this.game=game;
		
	}
	
	public void use(Item i){											//ran when an item is used up
		if(this.backpack.containsKey(i)){
			this.backpack.remove(i);
		}
	}
	
	public void loot(Item i,int num){									//ran when items are found. num=amount found
		if(this.backpack.containsKey(i)){
			int temp = this.backpack.get(i);
			this.backpack.put(i, temp += num);
		}
		else{
			this.backpack.put(i, num);
		}
	}
	
}
