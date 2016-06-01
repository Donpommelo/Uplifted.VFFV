package dev.zt.UpliftedVFFV.statusEffects.Special;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BathHouseIntrinsic extends status{
	
	public static String name = "Bathhouse Effect";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public GameState gs;
	
	public BathHouseIntrinsic(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		int meep = bs.gs.getVar(15);
		switch(meep){
		case 1:
			for(Schmuck ally : bs.gs.getPartymanager().getParty()){
				ally.bonusStats[34]+=(int)(s.getMaxHp()*.025);
				ally.bonusStats[35]+=(int)(s.getMaxBp()*.025);
			}
			break;
		case 2:
			s.bonusStats[11] += 8;
			break;
		case 3:
			s.bonusStats[12] -= .25;
			break;
		case 4:
			for(Schmuck ally : bs.gs.getPartymanager().getParty()){
				ally.bonusStats[2] -= .9;
				ally.bonusStats[3] -= .9;
				ally.bonusStats[4] -= .9;
				ally.buffedStats[2] += 15;
				ally.buffedStats[3] += 15;
				ally.buffedStats[4] += 15;
				ally.buffedStats[5] += 15;
				ally.buffedStats[6] += 15;
				ally.buffedStats[7] += 15;
			}
			break;
		}
	}

	public Boolean runWhenDead(){
		return true;
	}
	
}
