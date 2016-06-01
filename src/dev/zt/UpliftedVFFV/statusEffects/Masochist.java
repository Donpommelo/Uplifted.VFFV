package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Masochist extends status{
	
	public double percent;
	public static String name = "Masochism";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Masochist(int i, double percent, Schmuck perp, Schmuck vic,  int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.percent = percent;
	}
	
	public Masochist(double percent, Schmuck v,int pr){
		super(name, v,pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage,int elem){
		double perc = percent;
		if(this.isEquipment()){
			perc = perc *(1+vic.getEquipPow());
		}
		if(damage >= vic.getMaxHp()*.1){
			bs.bp.bt.addScene(vic.getName()+" seems to be enjoying it!");
			vic.bpChange((int)(damage*perc));
		}	
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Masochistic and will regain Mp when hit!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer masochistic.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
