package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Midgeon;
import dev.zt.UpliftedVFFV.party.enemy.Portent;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;
import dev.zt.UpliftedVFFV.party.enemy.Screamer;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;

public class Troop23LeaderandCo2 extends Troop{

	int num1;
	int num2;
	public Troop23LeaderandCo2(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		num1 = (int)(Math.random()*2);
		num2 = (int)(Math.random()*3);
		switch (num1){
		case 0:
			troop.add(new Midgeon(ML));
			troop.add(new Midgeon(ML));
			break;
		case 1:
			troop.add(new RotThought(ML));
			troop.add(new RotThought(ML));
			break;
		}
		switch (num2){
		case 0:
			troop.add(new Shirley(1+ML));
			break;
		case 1:
			troop.add(new Lunk(1+ML));
			break;
		case 2:
			troop.add(new Portent(1+ML));
			break;
		}
		switch (num1){
		case 0:
			troop.add(new Midgeon(ML));
			troop.add(new Midgeon(ML));
			break;
		case 1:
			troop.add(new Screamer(ML));
			troop.add(new Screamer(ML));
			break;
		}
		
		this.troop = troop;
		return troop;
	}
		
	public String encounterText(){
		String temp1 = "";
		String temp2 = "";
		switch(num1){
		case 0:
			temp1 = "Midgeons";
			break;
		case 1:
			temp1 = "Rot Thoughts";
			break;
		}
		switch(num2){
		case 0:
			temp2 = "Shirley";
			break;
		case 1:
			temp2 = "Lunk";
			break;
		case 2:
			temp2 = "Portent";
			break;
		}
		return "You are fighting a(n) "+temp2+" and its company of "+temp1;
		
		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
