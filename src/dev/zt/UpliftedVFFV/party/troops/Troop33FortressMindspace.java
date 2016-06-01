package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.FortressMindspace;
import dev.zt.UpliftedVFFV.party.enemy.MensBestFriends;
import dev.zt.UpliftedVFFV.party.enemy.PlatedGhost;
import dev.zt.UpliftedVFFV.party.enemy.PleatedGhost;

public class Troop33FortressMindspace extends Troop{

	public Troop33FortressMindspace(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num1 = (int)(Math.random()*3);
		switch(num1){
		case 0:
			troop.add(new MensBestFriends(ML));
			break;
		case 1:
			troop.add(new PlatedGhost(ML));
			break;
		case 2:
			troop.add(new PleatedGhost(ML));
			break;
		}		
		
		troop.add(new FortressMindspace(ML));

		switch(num1){
		case 0:
			troop.add(new MensBestFriends(ML));
			break;
		case 1:
			troop.add(new PlatedGhost(ML));
			break;
		case 2:
			troop.add(new PleatedGhost(ML));
			break;
			
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by Fortress Mindspaces!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
