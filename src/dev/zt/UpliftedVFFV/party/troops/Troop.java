package dev.zt.UpliftedVFFV.party.troops;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;

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
	public static Troop Troop8 = new Troop8OfficeDiversitySouth(8);
	public static Troop Troop9 = new Troop9BadEggGang(9);
	public static Troop Troop10 = new Troop10LeaderandCo(10);
	public static Troop Troop11 = new Troop11CoffeeElemental(11);
	public static Troop Troop12 = new Troop12Thoughts(12);
	public static Troop Troop13 = new Troop13EastOfficePreview(13);
	public static Troop Troop14 = new Troop14WanderingMind(14);
	public static Troop Troop15 = new Troop15BossJorge(15);
	public static Troop Troop16 = new Troop16MidgeonSwarm(16);
	public static Troop Troop17 = new Troop17ChameleonandCo(17);
	public static Troop Troop18 = new Troop18ChameleonDuo(18);
	public static Troop Troop19 = new Troop19SymphonyofScreamers(19);
	public static Troop Troop20 = new Troop20CopyCat(20);
	public static Troop Troop21 = new Troop21OfficeDiversityEast(21);
	public static Troop Troop22 = new Troop22PortentGang(22);
	public static Troop Troop23 = new Troop23LeaderandCo2(23);
	public static Troop Troop24 = new Troop24KillingTime(24);
	public static Troop Troop25 = new Troop25MansBestFriends(25);
	public static Troop Troop26 = new Troop26Harbinger(26);
	public static Troop Troop27 = new Troop27Floaters(27);
	public static Troop Troop28 = new Troop28Panopticon(28);
	public static Troop Troop29 = new Troop29FeelingYouTookAWrongTurn(29);
	public static Troop Troop30 = new Troop30FeelingofBeingWatched(30);
	public static Troop Troop31 = new Troop31JustAFeeling(31);
	public static Troop Troop32 = new Troop32PleatedPlatedGhosts(32);
	public static Troop Troop33 = new Troop33FortressMindspace(33);
	public static Troop Troop34 = new Troop34Midgiraffe(34);
	
	protected final int id;
	public ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	public TreeMap<Item, Integer> drops = new TreeMap<Item, Integer>();
	public int bonusML;
	
//	public String encounterText = "";
	

 	public Troop(int id){
 		this.id = id;
 		troops[id] = this;
 	}
	
 	//Generates troop. Each troop overrides this method.
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
	
	public TreeMap<Item, Integer> getDrops(double bonusDrop){
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
