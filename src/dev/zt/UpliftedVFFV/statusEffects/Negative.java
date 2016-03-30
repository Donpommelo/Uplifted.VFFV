package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Negative extends status{
	
	public static String name = "Negativity";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Negative(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic,pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		vic.hpChange(-damage);
		return 0;
	}
	
	public int onHealTargetEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		vic.hpChange(-damage);
		return 0;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Negative!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Negativity wore off!";
	}
	
}
