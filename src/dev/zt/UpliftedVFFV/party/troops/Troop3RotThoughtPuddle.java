package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop3RotThoughtPuddle extends Troop{

	public Troop3RotThoughtPuddle(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = (int)(Math.random()*2+2);
		for(int i=0; i<num; i++){
			troop.add(new RotThought(ML));
		}
		this.troop = troop;
		return troop;
	}
	
	public String encounterText(){
		return "You were surrounded by Rot Thoughts!";		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
