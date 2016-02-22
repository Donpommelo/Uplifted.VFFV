package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop8OfficeDiversitySouth extends Troop{

	public Troop8OfficeDiversitySouth(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop = new ArrayList<Schmuck>();
		ArrayList<Schmuck> tempList = new ArrayList<Schmuck>();
		tempList.add(new Midge(1+ML));tempList.add(new RotThought(1+ML));tempList.add(new Augur(1+ML));tempList.add(new BadEgg(1+ML));tempList.add(new IllRat(1+ML));
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
