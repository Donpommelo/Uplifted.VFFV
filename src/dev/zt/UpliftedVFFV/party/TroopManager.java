package dev.zt.UpliftedVFFV.party;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.enemy.BossJorge;

public class TroopManager {
	private Game game;
	private Troop troop;

	
	
	public TroopManager(Game game){
		this.game=game;
//		troop = new Troop(0);
	}
	
	public ArrayList<Schmuck> Troop(int index, int ML){
/*		for(Schmuck s : Troop.troops[index].troop){
			s.calcStats(s.getLvl());
			s.statuses.clear()
			s.skills.clear();
		}*/
//		return Troop.troops[index].troop;
//		return troop.findTroop(index);
//		return Troop.TroopTest.genTroop();
		return Troop.troops[index].genTroop(ML);
		
	}

}
