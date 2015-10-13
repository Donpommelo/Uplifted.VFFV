package dev.zt.UpliftedVFFV.statusEffects.Stats;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DamageCap extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int statChanged;
	public int capAmount;
	public DamageCap(int i, int stat, int cap, Schmuck perp, int pr){
		super(i, "Damage Cap", false, false, true, perp, pr);
		this.statChanged = stat;
		this.capAmount = cap;
	}
	
	public DamageCap(int stat, int cap, Schmuck perp, int pr){
		super("Damage Cap", false, false, perp, pr);
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
		return "";//s.getName()+"'s elemental alignments went back to normal";
	}
}
