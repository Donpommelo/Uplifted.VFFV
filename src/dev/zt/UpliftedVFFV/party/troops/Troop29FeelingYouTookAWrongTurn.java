package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.FeelingYouTookaWrongTurn;

public class Troop29FeelingYouTookAWrongTurn extends Troop{

	public Troop29FeelingYouTookAWrongTurn(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new FeelingYouTookaWrongTurn(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You feel like you took a wrong turn...";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
