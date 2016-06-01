package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.RotThoughtTutorial;

public class Troop0Test extends Troop{

//	public static ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	public Troop0Test(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		Schmuck tutorial = new RotThoughtTutorial(ML);
		troop.add(tutorial);
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		return "You were assaulted by a Rotthought!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
