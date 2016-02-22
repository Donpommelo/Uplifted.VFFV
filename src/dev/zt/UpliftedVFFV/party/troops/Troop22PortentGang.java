package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;
import dev.zt.UpliftedVFFV.party.enemy.Portent;

public class Troop22PortentGang extends Troop{

	public Troop22PortentGang(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		int num = (int)(Math.random()*3+1);
		troop.add(new Portent(1+ML));
		for(int i=0; i<num; i++){
			troop.add(new Augur(1+ML));
		}
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		return "You were attacked by Portent and co!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
