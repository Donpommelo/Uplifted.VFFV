package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Midge;

public class Troop1MidgeSwarm extends Troop{

	public Troop1MidgeSwarm(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = (int)(Math.random()*3+4);
		for(int i=0; i<num; i++){
			troop.add(new Midge(ML));
		}
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		switch(this.troop.size()){
		case 4:
			return "You encountered a below-average-sized swarm of Midges!";
		case 5:
			return "You encountered an average-sized swarm of Midges!";
		case 6:
			return "You encountered a above-average-sized swarm of Midges!";
		}
		return "You encountered a below-average-sized swarm of Midges!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
