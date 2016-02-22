package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Chameleon;

public class Troop18ChameleonDuo extends Troop{

	public Troop18ChameleonDuo(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		troop.add(new Chameleon(1+ML));
		troop.add(new Chameleon(1+ML));

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
