package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;

public class Troop6Trio extends Troop{

	int num1;
	int num2;
	public Troop6Trio(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		num1 = (int)(Math.random()*3);
		num2 = (int)(Math.random()*3);
		switch (num1){
		case 0:
			troop.add(new Midge(ML));
			break;
		case 1:
			troop.add(new Augur(ML));
			break;
		case 2:
			troop.add(new BadEgg(ML));
			break;
		}
		switch (num2){
		case 0:
			troop.add(new BadEgg(1+ML));
			break;
		case 1:
			troop.add(new RotThought(1+ML));
			break;
		case 2:
			troop.add(new IllRat(1+ML));
			break;
		}
		switch (num1){
		case 0:
			troop.add(new Midge(ML));
			break;
		case 1:
			troop.add(new Augur(ML));
			break;
		case 2:
			troop.add(new BadEgg(ML));
			break;
		}
		
		this.troop = troop;
		return troop;
	}

	public String encounterText(){
		switch(num2){
		case 0:
			return "You are attacked by Bad Egg and co!";
		case 1:
			return "You are attacked by Rot Thought and co!";
		case 2:
			return "You are attacked by Ill Rat and co!";
		}
		return "You are beset by an assortment of foe!";
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
