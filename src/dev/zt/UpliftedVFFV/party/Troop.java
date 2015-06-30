package dev.zt.UpliftedVFFV.party;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;
import dev.zt.UpliftedVFFV.party.enemy.CoffeeElem;
import dev.zt.UpliftedVFFV.party.enemy.EyeCatcher;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;
import dev.zt.UpliftedVFFV.party.troops.Troop0Test;
import dev.zt.UpliftedVFFV.party.troops.Troop10LeaderandCo;
import dev.zt.UpliftedVFFV.party.troops.Troop11CoffeeElemental;
import dev.zt.UpliftedVFFV.party.troops.Troop12Thoughts;
import dev.zt.UpliftedVFFV.party.troops.Troop1MidgeSwarm;
import dev.zt.UpliftedVFFV.party.troops.Troop2IllRatHorde;
import dev.zt.UpliftedVFFV.party.troops.Troop3RotThoughtPuddle;
import dev.zt.UpliftedVFFV.party.troops.Troop4EyeCatcher;
import dev.zt.UpliftedVFFV.party.troops.Troop5SmallSchmucks;
import dev.zt.UpliftedVFFV.party.troops.Troop6Trio;
import dev.zt.UpliftedVFFV.party.troops.Troop7Augurs;
import dev.zt.UpliftedVFFV.party.troops.Troop8OfficeDiversity;
import dev.zt.UpliftedVFFV.party.troops.Troop9BadEggGang;


public class Troop implements Comparable<Troop>{

	public static Troop[] troops = new Troop[512];
	public static Troop TroopTest = new Troop0Test(0);
	public static Troop Troop1 = new Troop1MidgeSwarm(1);
	public static Troop Troop2 = new Troop2IllRatHorde(2);
	public static Troop Troop3 = new Troop3RotThoughtPuddle(3);
	public static Troop Troop4 = new Troop4EyeCatcher(4);
	public static Troop Troop5 = new Troop5SmallSchmucks(5);
	public static Troop Troop6 = new Troop6Trio(6);
	public static Troop Troop7 = new Troop7Augurs(7);
	public static Troop Troop8 = new Troop8OfficeDiversity(8);
	public static Troop Troop9 = new Troop9BadEggGang(9);
	public static Troop Troop10 = new Troop10LeaderandCo(10);
	public static Troop Troop11 = new Troop11CoffeeElemental(11);
	public static Troop Troop12 = new Troop12Thoughts(12);
	

	
	protected final int id;
	public ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	public TreeMap<Item, Integer> drops = new TreeMap<Item, Integer>();
	public int bonusML;
	
//	public String encounterText = "";
	

 	public Troop(int id){
 		this.id = id;
 		troops[id] = this;
 	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new BossJorge(999+ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "";
	}
	
	public TreeMap<Item, Integer>  getDrops(double bonusDrop){
		TreeMap<Item, Integer> itemdrops = new TreeMap<>();		
		for(Schmuck s : this.troop){
			Set<Item> temp = s.getItemdrops().keySet();
			Item[] itemDisplay = temp.toArray(new Item[999]);
			for(int i=0; i<s.getItemdrops().size();i++){		
				if(Math.random()<=(s.getItemdrops().get(itemDisplay[i]))*(1+bonusDrop)){
					if(itemdrops.containsKey(itemDisplay[i])){
						int tempint = itemdrops.get(itemDisplay[i]);
						itemdrops.put(itemDisplay[i], tempint + 1);
					}
					else{
						itemdrops.put(itemDisplay[i], 1);
					}
				}
			}
		}
		this.drops = itemdrops;
		return itemdrops;
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}
	
	public TreeMap<Item, Integer> getItems() {
		return drops;
	}

	public void setTroop(ArrayList<Schmuck> troop) {
		this.troop = troop;
	}

	@Override
	public int compareTo(Troop arg0) {

		return 0;
	}
	
}
