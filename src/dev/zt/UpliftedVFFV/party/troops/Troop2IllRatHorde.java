package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;

public class Troop2IllRatHorde extends Troop{

	public Troop2IllRatHorde(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = (int)(Math.random()*2+2);
		for(int i=0; i<num; i++){
			troop.add(new IllRat(1+ML));
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "A gang of Ill Rats attack!";		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
