package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.CopyCat;
import dev.zt.UpliftedVFFV.party.enemy.EyeCatcher;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;

public class Troop20CopyCat extends Troop{

	public Troop20CopyCat(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Lunk(1+ML));
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You are attacked by a Copy-Cat!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
