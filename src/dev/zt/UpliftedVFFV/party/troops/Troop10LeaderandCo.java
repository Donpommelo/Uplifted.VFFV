package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop10LeaderandCo extends Troop{

	int num1;
	int num2;
	public Troop10LeaderandCo(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		num1 = (int)(Math.random()*2);
		num2 = (int)(Math.random()*3);
		switch (num1){
		case 0:
			troop.add(new Midge(2+ML));
			troop.add(new Midge(2+ML));
			break;
		case 1:
			troop.add(new RotThought(2+ML));
			troop.add(new RotThought(2+ML));
			break;
		}
		switch (num2){
		case 0:
			troop.add(new BadEgg(3+ML));
			break;
		case 1:
			troop.add(new Augur(3+ML));
			break;
		case 2:
			troop.add(new IllRat(3+ML));
			break;
		}
		switch (num1){
		case 0:
			troop.add(new Midge(2+ML));
			troop.add(new Midge(2+ML));
			break;
		case 1:
			troop.add(new RotThought(2+ML));
			troop.add(new RotThought(2+ML));
			break;
		}
		
		this.troop = troop;
		return troop;
	}
	
	public TreeMap<Item, Integer>  getDrops(){
		return super.getDrops();
	}
	
	public String encounterText(){
		String temp1 = "";
		String temp2 = "";
		switch(num1){
		case 0:
			temp1 = "Midges";
			break;
		case 1:
			temp1 = "Rot Thoughts";
			break;
		}
		switch(num2){
		case 0:
			temp2 = "Bad Egg";
			break;
		case 1:
			temp2 = "Augur";
			break;
		case 2:
			temp2 = "Ill Rat";
			break;
		}
		return "You are fighting a(n) "+temp2+" and its company of "+temp1;
		
		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
