package dev.zt.UpliftedVFFV.party;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;

public class TroopManager {
	private Game game;
	private Troop troop;
	Schmuck operator=new Operator();
	Schmuck penpal=new PenPal();
	Schmuck jorge1= new BossJorge();
	Schmuck jorge2= new BossJorge();
	Schmuck jorge3= new BossJorge();
	Schmuck enemy1;
	Schmuck enemy2;
	Schmuck enemy3;
	Schmuck enemy4;
	Schmuck enemy5;
	
	
	public TroopManager(Game game){
		this.game=game;
		troop = new Troop(0);
	}
	
	public ArrayList<Schmuck> Troop(int index){
/*		for(Schmuck s : Troop.troops[index].troop){
			s.calcStats(s.getLvl());
			s.skills.clear();
		}*/
		return Troop.troops[index].troop;
//		return troop.findTroop(index);
	}

}
