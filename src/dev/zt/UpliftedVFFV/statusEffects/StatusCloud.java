package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class StatusCloud extends status{
	
	public static String name = "Status Cloud";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public status st;
	public double perc;
	public StatusCloud(int i, double perc, status st, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.st = st;
		this.perc = perc;
	}
	public StatusCloud(int pr, double perc, Schmuck v,status st){
		super("Status Cloud", v,pr);
		this.st = st;
		this.perc = perc;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(-damage > vic.getMaxHp() * perc){
			if(Math.random() < .6*vic.getBuffedLuk()/perp.getBuffedLuk()){
				st.setVic(perp);
				bs.bp.stm.addStatus(perp,st);
			}
		}
		return damage;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was surrounded by a status-inflicting cloud!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s status-inflicting cloud faded!";
	}

	public int stackingEffect(){
		return 2;
	}
	
}
