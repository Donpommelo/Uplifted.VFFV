package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;

public class Troop16MidgeonSwarm extends Troop{

	public Troop16MidgeonSwarm(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = (int)(Math.random()*3+4);
		troop.add(new Midgeon(1+ML));
		for(int i=0; i<num; i++){
			troop.add(new Midge(1+ML));
		}
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		return "You were attacked by a Midgeon and its brood!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
