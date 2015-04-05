package dev.zt.UpliftedVFFV.inventory;

import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;

public class InventoryManager {
	
	private Game game;
	public TreeMap<Item, Integer> backpack = new TreeMap<>();
	
	
	public InventoryManager(Game game){
		this.game=game;
		
	}
	
	public void use(Item i){
		if(this.backpack.containsKey(i)){
			this.backpack.remove(i);
		}
	}
	
	public void loot(Item i,int num){
		if(this.backpack.containsKey(i)){
			int temp = this.backpack.get(i);
			this.backpack.put(i, temp += num);
		}
		else{
			this.backpack.put(i, num);
		}
	}
	
}
