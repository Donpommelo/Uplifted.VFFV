package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DamageCap extends status{
	
	public static String name = "Damage Cap";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public int statChanged;
	public int capAmount;
	public DamageCap(int i, int stat, int cap, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.statChanged = stat;
		this.capAmount = cap;
	}
	
	public DamageCap(int stat, int cap, int pr){
		super(name, pr);
		this.statChanged = stat;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(statChanged == elem || statChanged == 7){
			if(damage > capAmount){
				damage = capAmount;
			}
		}
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		String stat = "";
		switch(statChanged){
		case 0:
			stat = "Red";
			break;
		case 1:
			stat = "Blue";
			break;
		case 2:
			stat = "Green";
			break;
		case 3:
			stat = "Yellow";
			break;
		case 4:
			stat = "Purple";
			break;
		case 5:
			stat = "???";
			break;
		case 6:
			stat = "Physical";
			break;
		case 7:
			stat = "Universal";
			break;
		}
		
		return s.getName()+" gained a "+ stat + " Damage Cap!";
	}

	public String cureText(Schmuck s){
		return "'s Damage Cap went away!";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
