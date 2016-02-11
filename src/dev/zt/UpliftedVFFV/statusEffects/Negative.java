package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Negative extends status{
	
	public static String name = "Negativity";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Negative(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Negative(int pr){
		super(name, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		vic.hpChange(-damage);
		return 0;
	}
	
	public int onHealEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		vic.hpChange(-damage);
		return 0;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" gained became Negative!";
	}

	public String cureText(Schmuck s){
		return "'s Negativity wore off!";
	}
	
}
