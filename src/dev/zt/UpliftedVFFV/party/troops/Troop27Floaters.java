package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Floater;

public class Troop27Floaters extends Troop{

	public Troop27Floaters(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Floater(ML));
		troop.add(new Floater(ML));
		troop.add(new Floater(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "Several Floaters descend upon you!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
