package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Chameleon;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;
import dev.zt.UpliftedVFFV.party.enemy.Screamer;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;

public class Troop17ChameleonandCo extends Troop{

	public Troop17ChameleonandCo(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num1 = (int)(Math.random()*4);
		switch(num1){
		case 0:
			troop.add(new Lunk(1+ML));
			break;
		case 1:
			troop.add(new Shirley(1+ML));
			break;
		case 2:
			troop.add(new Screamer(1+ML));
			break;
		case 3:
			troop.add(new Midgeon(1+ML));
			break;
		}

		troop.add(new Chameleon(1+ML));
		
		switch(num1){
		case 0:
			troop.add(new Lunk(1+ML));
			break;
		case 1:
			troop.add(new Shirley(1+ML));
			break;
		case 2:
			troop.add(new Screamer(1+ML));
			break;
		case 3:
			troop.add(new Midgeon(1+ML));
			break;
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by a Chameleon and company!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
