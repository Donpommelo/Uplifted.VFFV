package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Masochist extends status{
	
	public double percent;
	public static String name = "Masochistic";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Masochist(int i, double percent, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.percent = percent;
	}
	
	public Masochist(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage,int elem){
		if(damage >= vic.getMaxHp()*.1){
			bs.bp.bt.textList.add(vic.getName()+" seems to be enjoying it!");
			vic.bpChange((int)(damage*percent));
		}	
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" became masochistic!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer masochistic.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
