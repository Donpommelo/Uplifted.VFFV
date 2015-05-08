package dev.zt.UpliftedVFFV.party;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Midge;


public class Troop implements Comparable<Troop>{

	public static Troop[] troops = new Troop[512];
	public static Troop trooptest = new Troop(0);
	public static Troop troop1 = new Troop(1);
	public static Troop troop2 = new Troop(2);
	
	protected final int id;
	public ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
	


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
			break;
		case 2:
			this.troop.add(new IllRat());
			this.troop.add(new IllRat());
			break;
		
		}
	}
	
	public ArrayList<Schmuck> findTroop(int id){
		ArrayList<Schmuck> troop=new ArrayList<Schmuck>();
		switch(id){
		case 0:
			BossJorge jorge1 = new BossJorge();
			troop.add(jorge1);
			break;
		case 1:
			break;
		case 2:
			break;
		
		}
		return troop;
	}

	@Override
	public int compareTo(Troop arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
