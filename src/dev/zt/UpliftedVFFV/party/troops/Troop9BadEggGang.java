package dev.zt.UpliftedVFFV.party.troops;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;

public class Troop9BadEggGang extends Troop{

//	public static ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	public Troop9BadEggGang(int id) {
		super(id);
	}
	
	public ArrayList<Schmuck> genTroop(int ML){
		this.bonusML = ML;
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		for(int i=0; i<3; i++){
			troop.add(new BadEgg(1+ML));
		}
		this.troop = troop;
		return troop;
	}
	
	public TreeMap<Item, Integer>  getDrops(double bonusDrop){
		return super.getDrops(bonusDrop);
	}
	
	public String encounterText(){
		int temp = (int)(Math.random()*3);
		switch (temp){
		case 0:
			return "Bad Egg: Hey, you! You lookin' at me?";
		case 1:
			return "Bad Egg: Hey, you! You think you tough or something?";
		case 2:
			return "Bad Egg: Hey, you! Yeah you! I'm talkin' to you!";
		}
		return "Bad Egg: I don't like that look you givin' me!";
		
		
		
	}
	
	public ArrayList<Schmuck> getTroop() {
		return troop;
	}

}
