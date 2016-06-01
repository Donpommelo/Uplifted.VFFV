package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.MensBestFriends;

public class Troop25MansBestFriends extends Troop{

	public Troop25MansBestFriends(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new MensBestFriends(ML));
		troop.add(new MensBestFriends(ML));
		troop.add(new MensBestFriends(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "Men's Best Friends nibble at your heels!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
