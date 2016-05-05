package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Midgiraffe;

public class Troop34Midgiraffe extends Troop{

	public Troop34Midgiraffe(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Midgiraffe(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by a Midgiraffe!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
