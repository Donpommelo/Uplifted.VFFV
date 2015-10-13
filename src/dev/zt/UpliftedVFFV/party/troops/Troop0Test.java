package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.misc.PostageStamp;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;

public class Troop0Test extends Troop{

//	public static ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	public Troop0Test(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new BossJorge(1+ML));
		this.troop = troop;
		return troop;
	}
	
	public TreeMap<Item, Integer>  getDrops(){
		TreeMap<Item, Integer> itemdrops = new TreeMap<>();
		itemdrops.put(new PostageStamp(), 3);
		itemdrops.put(new LetterOpener(), 1);
		this.drops = itemdrops;
		return itemdrops;
	}
	
	public String encounterText(){
		return "Jorge: Heh! No runnin' now!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
