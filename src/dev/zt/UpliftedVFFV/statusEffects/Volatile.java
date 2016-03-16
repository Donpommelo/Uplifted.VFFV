package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Volatile extends status{
	
	public static String name = "Volatility";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Volatile(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Volatile(int pr){
		super(name, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(damage>Math.random()*500){
			bs.bp.bt.addScene("The blow causes "+vic.getName()+"'s bucket to explode!");
			for(Schmuck s : bs.bs.enemySelectable){
				s.hpChange(-60);
			}
			for(Schmuck s : bs.bs.alliesSelectable){
				s.hpChange(-60);
			}
		}
		bs.bs.targetUpdate();
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks unstable!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" looks stable again!";
	}
}
