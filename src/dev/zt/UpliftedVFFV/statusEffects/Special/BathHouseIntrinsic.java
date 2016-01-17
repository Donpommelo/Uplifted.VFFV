package dev.zt.UpliftedVFFV.statusEffects.Special;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BathHouseIntrinsic extends status{
	
	public static String name = "Bathhouse Effect";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public GameState gs;
	public BathHouseIntrinsic(int i, Schmuck perp, int pr, GameState gs){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.gs = gs;
	}
	
	public BathHouseIntrinsic(int pr){
		super(name, pr);
	}
	
	public void statchanges(Schmuck s){
		int meep = gs.getVar(15);
		switch(meep){
		case 1:
			s.bonusStats[34]+=(int)(s.getMaxHp()*.025);
			s.bonusStats[35]+=(int)(s.getMaxBp()*.025);
			break;
		case 2:
			s.bonusStats[11] += 8;
			break;
		case 3:
			s.bonusStats[12] -= .25;
			break;
		case 4:
			s.bonusStats[2] -= .75;
			s.bonusStats[3] -= .75;
			s.bonusStats[4] -= .75;
			s.buffedStats[2] += 15;
			s.buffedStats[3] += 15;
			s.buffedStats[4] += 15;
			s.buffedStats[5] += 15;
			s.buffedStats[6] += 15;
			s.buffedStats[7] += 15;
			break;
		}
	}

	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}
	
}
