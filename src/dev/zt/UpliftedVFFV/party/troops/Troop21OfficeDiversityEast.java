package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;
import dev.zt.UpliftedVFFV.party.enemy.Portent;
import dev.zt.UpliftedVFFV.party.enemy.Screamer;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;

public class Troop21OfficeDiversityEast extends Troop{

	public Troop21OfficeDiversityEast(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop = new ArrayList<Schmuck>();
		ArrayList<Schmuck> tempList = new ArrayList<Schmuck>();
		tempList.add(new Midgeon(ML));tempList.add(new Shirley(ML));tempList.add(new Screamer(ML));tempList.add(new Lunk(ML));tempList.add(new Portent(ML));
		for(int i = 0; i <5; i++){
			int tempIndex = (int)(Math.random()*tempList.size());
			Schmuck temp = tempList.get(tempIndex);
			troop.add(temp);
			tempList.remove(temp);
		}
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		return "You are attacked by a group of monsters!";		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
