package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;
import dev.zt.UpliftedVFFV.party.enemy.Screamer;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;

public class Troop13EastOfficePreview extends Troop{


	public Troop13EastOfficePreview(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Lunk(ML));
		troop.add(new Midgeon(ML));
		troop.add(new Screamer(ML));
		troop.add(new Shirley(ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are beset by an assortment of foe!";	
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
