package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.WanderingMind;

public class Troop14WanderingMind extends Troop{


	public Troop14WanderingMind(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new WanderingMind(1+ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "A Wandering Mind is minding your business!";		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
