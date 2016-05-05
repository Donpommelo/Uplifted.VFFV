package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.FeelingNothing;

public class Troop31JustAFeeling extends Troop{

	public Troop31JustAFeeling(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new FeelingNothing(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You suddenly feel unexplainably terrible!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
