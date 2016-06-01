package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DamageBlock extends status{
	
	public static String name = "Damage Block";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
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
	
	public DamageBlock(int i, double percent, int amount, int elem, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.percent = percent;
		this.amount = amount;
		this.elem = elem;
	}
	
	public DamageBlock(double percent, int amount, int elem,Schmuck v, int pr){
		super(name,v, pr);
		this.percent = percent;
		this.amount = amount;
		this.elem = elem;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int am = this.amount;
		double perc = this.percent;
		if(this.isEquipment()){
			am = (int) (am * (1 + vic.getEquipPow()));
			perc = perc * (1 + vic.getEquipPow());
		}
		int finaldamage = damage;
		if(elem == this.elem || this.elem == 7){
			if(Math.random() <= perc){
				finaldamage += am;
			}
		}
		if(finaldamage >= 0){
			finaldamage = -1;
		}
		return finaldamage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is blocking damage!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer blocking damage.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
