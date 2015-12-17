package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DamageBlock extends status{
	
	public int duration;
	public double percent;
	public int amount;
/*	0: Red
  	1: Blue
  	2: Green
  	3: Yellow
  	4: Purple
  	5: Void
  	6: Physical
  	7: All
  */
	public int elem;
	public Boolean perm = false;
	public Boolean visible = true;
	public DamageBlock(int i, double percent, int amount, int elem, Schmuck perp, int pr){
		super(i, "Damage Block", false, false, true, perp, pr);
		this.percent = percent;
		this.amount = amount;
		this.elem = elem;
	}
	
	public DamageBlock(double percent, int amount, int elem, Schmuck perp, int pr){
		super("Damage Block", false, false, perp, pr);
		this.percent = percent;
		this.amount = amount;
		this.elem = elem;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int finaldamage = damage;
		if(elem == this.elem || this.elem == 7){
			if(Math.random() <= this.percent){
				finaldamage -= this.amount;
			}
		}
		if(finaldamage <= 0){
			finaldamage = 1;
		}
		return finaldamage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is blocking damage!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer blocking damage.";
	}
}
