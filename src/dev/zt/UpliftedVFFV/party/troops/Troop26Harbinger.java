package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Harbinger;

public class Troop26Harbinger extends Troop{

	public Troop26Harbinger(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Harbinger(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "A Harbinger foresees your demise!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
