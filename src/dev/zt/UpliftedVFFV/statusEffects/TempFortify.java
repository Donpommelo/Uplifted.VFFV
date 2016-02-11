package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TempFortify extends status{
	
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
	public static String name = "Fortification";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public TempFortify(int elem, Schmuck perp, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
		this.elem = elem;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int finaldamage = damage;
		if(elem == this.elem || this.elem == 7){
			finaldamage = -1;
			bs.bp.stm.removeStatus(vic, this);
		}
		return finaldamage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is Fortified!";
	}

	public String cureText(Schmuck s){
		return "";
	}
	
	public int stackingEffect(){
		return 3;
	}
	
}
