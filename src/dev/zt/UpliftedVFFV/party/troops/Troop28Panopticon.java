package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Panopticon;

public class Troop28Panopticon extends Troop{

	public Troop28Panopticon(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Panopticon(ML+5));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are fighting Panopticon the All-Seeing!!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
