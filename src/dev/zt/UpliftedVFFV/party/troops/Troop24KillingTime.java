package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.CopyCat;
import dev.zt.UpliftedVFFV.party.enemy.KillingTime;

public class Troop24KillingTime extends Troop{

	public Troop24KillingTime(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new KillingTime(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "What time is it? It's Killing Time!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
