package dev.zt.UpliftedVFFV.party;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.enemy.Augur;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;
import dev.zt.UpliftedVFFV.party.enemy.CoffeeElem;
import dev.zt.UpliftedVFFV.party.enemy.EyeCatcher;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;


public class Troop implements Comparable<Troop>{

	public static Troop[] troops = new Troop[512];
	public static Troop trooptest = new Troop(0);
	public static Troop troop1 = new Troop(1);
	public static Troop troop2 = new Troop(2);
	public static Troop troop3 = new Troop(3);
	public static Troop troop4 = new Troop(4);
	public static Troop troop5 = new Troop(5);
	public static Troop troop6 = new Troop(6);
	public static Troop troop7 = new Troop(7);
	public static Troop troop8 = new Troop(8);
	public static Troop troop9 = new Troop(9);
	
	protected final int id;
	public ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	
	public String encounterText = "";
	


	public Troop(int id){
		this.id = id;
		troops[id] = this;
		switch(id){
		case 0:
			this.troop.add(new BossJorge());
			break;
		case 1:
			this.troop.add(new Midge());
			this.troop.add(new Midge());
			this.troop.add(new Midge());
			this.troop.add(new Midge());
			this.troop.add(new Midge());
			break;
		case 2:
			this.troop.add(new IllRat());
			this.troop.add(new IllRat());
			break;
		case 3:
			this.troop.add(new RotThought());
			this.troop.add(new RotThought());
			break;
		case 4:
			this.troop.add(new EyeCatcher());
			break;
		case 5:
			this.troop.add(new Midge());
			this.troop.add(new RotThought());
			this.troop.add(new IllRat());
			break;
		case 6:
			this.troop.add(new BadEgg());
			this.troop.add(new RotThought());
			this.troop.add(new BadEgg());
			break;
		case 7:
			this.troop.add(new Augur());
			this.troop.add(new Augur());
			this.troop.add(new Augur());
			break;
		case 8:
			this.troop.add(new BadEgg());
			this.troop.add(new Augur());
			this.troop.add(new Midge());
			this.troop.add(new RotThought());
			this.troop.add(new IllRat());
			break;
		case 9:
			this.troop.add(new CoffeeElem());
			break;
		}
	}
	
/*	public ArrayList<Schmuck> findTroop(int id){
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		switch(id){
		case 0:
			troop.add(new BossJorge());
			break;
		case 1:
			troop.add(new Midge());
			troop.add(new Midge());
			troop.add(new Midge());
			troop.add(new Midge());
			troop.add(new Midge());
			break;
		case 2:
			troop.add(new IllRat());
			troop.add(new IllRat());
			break;
		case 3:
			troop.add(new RotThought());
			troop.add(new RotThought());
			break;
		case 4:
			troop.add(new EyeCatcher());
			break;
		case 5:
			troop.add(new Midge());
			troop.add(new RotThought());
			troop.add(new IllRat());
			break;
		case 6:
			troop.add(new BadEgg());
			troop.add(new RotThought());
			troop.add(new BadEgg());
			break;
		case 7:
			troop.add(new Augur());
			troop.add(new Augur());
			troop.add(new Augur());
			break;
		case 8:
			troop.add(new BadEgg());
			troop.add(new Augur());
			troop.add(new Midge());
			troop.add(new RotThought());
			troop.add(new IllRat());
			break;
		case 9:
			troop.add(new CoffeeElem());
			break;
		}
		return troop;
	}*/

	@Override
	public int compareTo(Troop arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
