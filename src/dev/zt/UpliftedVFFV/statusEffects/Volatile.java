package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Volatile extends status{
	
	public int duration;

	public Boolean perm = false;
	public Boolean visible = true;
	public Volatile(int i, Schmuck perp){
		super(i, "Volatile", false, false, true, perp);
	}
	
	public Volatile(Schmuck perp){
		super("Volatile", false, false, perp);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(damage>Math.random()*500){
			bs.bp.bt.textList.add("The blow causes "+vic.getName()+"'s bucket to explode!");
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
		return s.getName()+" is reflecting damage!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer reflecting damage.";
	}
}
