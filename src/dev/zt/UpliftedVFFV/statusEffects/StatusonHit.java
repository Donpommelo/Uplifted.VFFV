package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class StatusonHit extends status{
	
	public static String name = "Status on Hit";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public status st;
	public double perc;
	public StatusonHit(int i, double perc, status st, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.st = st;
		this.perc = perc;
	}
	public StatusonHit(int pr, double perc, status st){
		super(name, pr);
		this.st = st;
		this.perc = perc;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		if(Math.random() < perc * (1+perp.getEquipPow())*(float)(perp.getBuffedLuk()/vic.getBuffedLuk())){
			bs.bp.stm.addStatus(vic, st);
		}
	}
	
	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}

	public int stackingEffect(){
		return 2;
	}
	
}
