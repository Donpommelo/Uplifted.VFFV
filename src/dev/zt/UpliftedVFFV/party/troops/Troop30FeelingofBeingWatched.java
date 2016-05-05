package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.FeelingOfBeingWatched;

public class Troop30FeelingofBeingWatched extends Troop{

	public Troop30FeelingofBeingWatched(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new FeelingOfBeingWatched(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You feel like you are being watched!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
