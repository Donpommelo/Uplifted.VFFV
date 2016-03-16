package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Delicious extends status{
	
	public double percent;
	public static String name = "Delicious";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Delicious(int i, double percent, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.percent = percent;
	}
	
	public Delicious(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(perp.getName()+" looks replenished.");
		bs.bp.em.hpChange((int)(damage*percent), vic, perp,6);
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks more delicious!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't look delicious anymore.";
	}
	
	public Boolean isBad(){
		return true;
	}
	
	public int stackingEffect(){
		return 3;
	}
}
