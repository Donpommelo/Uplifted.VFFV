package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop12Thoughts extends Troop{


	public Troop12Thoughts(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		for(int i = 0; i < 5; i++){
			int num = (int)(Math.random()*2);
			switch(num){
			case 0:
				troop.add(new RotThought(2+ML));
				break;
			case 1:
				troop.add(new Augur(2+ML));
				break;
			}
		}
		this.troop = troop;
		return troop;
	}
	
	public TreeMap<Item, Integer>  getDrops(double bonusDrop){
		return super.getDrops(bonusDrop);
	}
	
	public String encounterText(){
		return "You are beset by an assortment of foe!";
		
		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
