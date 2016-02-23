package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Screamer;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;

public class Troop19SymphonyofScreamers extends Troop{

	public Troop19SymphonyofScreamers(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num1 = (int)(Math.random()*3);

		troop.add(new Screamer(1+ML));
		
		switch(num1){
		case 0:
			troop.add(new Lunk(1+ML));
			break;
		case 1:
			troop.add(new Shirley(1+ML));
			break;
		case 3:
			troop.add(new Screamer(1+ML));
			break;
		}
		troop.add(new Screamer(1+ML));

		
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by Screamers!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
