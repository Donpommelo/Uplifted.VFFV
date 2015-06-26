package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
import dev.zt.UpliftedVFFV.party.enemy.CoffeeElem;

public class Troop11CoffeeElemental extends Troop{

	public Troop11CoffeeElemental(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new CoffeeElem(1+ML));
		this.troop = troop;
		return troop;
	}
	
	public TreeMap<Item, Integer>  getDrops(){
		return super.getDrops();
	}
	
	public String encounterText(){
		return "Coffee Elemental attacks!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}