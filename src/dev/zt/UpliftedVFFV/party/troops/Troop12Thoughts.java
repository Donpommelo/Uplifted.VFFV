package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop12Thoughts extends Troop{


	public Troop12Thoughts(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		for(int i = 0; i < 4; i++){
			int num = (int)(Math.random()*3);
			switch(num){
			case 0:
				troop.add(new RotThought(ML));
				break;
			case 1:
				troop.add(new Augur(ML));
				break;
			case 2:
				troop.add(new Augur(ML));
				break;
			}
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are beset by an assortment of foe!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
