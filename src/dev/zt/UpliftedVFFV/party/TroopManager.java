package dev.zt.UpliftedVFFV.party;

import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.troops.Troop;

public class TroopManager {
//	private Game game;
//	private Troop troop;

	
	
	public TroopManager(Game game){
//		this.game=game;
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

		ArrayList<Schmuck> foes = Troop.troops[index].genTroop(ML);
		TreeMap <String,Integer> freq = new TreeMap<String,Integer>();
		TreeMap <String,Integer> freqNew = new TreeMap<String,Integer>();

		for(Schmuck foe : foes){
			if(freq.containsKey(foe.getName())){
				freq.put(foe.getName(), freq.get(foe.getName())+1);
			}
			else{
				freq.put(foe.getName(), 1);
			}
		}
		
		for(String foe : freq.keySet()){
			if(freq.get(foe) != 1){
				freqNew.put(foe, freq.get(foe));
			}
		}
		
		for(Schmuck foe : foes){
			if(freqNew.containsKey(foe.getName())){
				freqNew.put(foe.getName(),freqNew.get(foe.getName())-1);
				foe.setName(foe.getName()+"("+(freqNew.get(foe.getName())+1)+")");
			}
		}


		return foes;
		
	}

}
