package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.PlatedGhost;
import dev.zt.UpliftedVFFV.party.enemy.PleatedGhost;

public class Troop32PleatedPlatedGhosts extends Troop{

	public Troop32PleatedPlatedGhosts(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		for(int i = 1; i<4; i++){
			if(Math.random() < .5){
				troop.add(new PleatedGhost(ML));
			}
			else{
				troop.add(new PlatedGhost(ML));
			}
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by swarms of ghosts!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
