package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Frozen extends status{
	
	public static String name = "Freeze";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Frozen(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
	}
	
	public Frozen(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is frozen solid!"),bs));
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int finaldamage = damage;
		double resist = .5+inflicter.getBluePoints()/200;
		finaldamage *= (1-resist);
		if(finaldamage < 0){
			return finaldamage;
		}
		else{
			return -1;
		}
	}	

	public String inflictText(Schmuck s){
		return s.getName()+" was Frozen!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" thawed out!";
	}
	
	public Boolean isBad(){
		return true;
	}
	
	public Boolean isDisable(){
		return true;
	}
	
	public int stackingEffect(){
		return 1;
	}
}
