package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.EyeCatcher;

public class Troop4EyeCatcher extends Troop{

	public Troop4EyeCatcher(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new EyeCatcher(1+ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "An Eye Catcher pounces!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
