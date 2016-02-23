package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Augur;

public class Troop7Augurs extends Troop{

	public Troop7Augurs(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = 3;
		for(int i=0; i<num; i++){
			troop.add(new Augur(1+ML));
		}
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		return "A group of Augurs foresee a terrible fate for you!";		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
