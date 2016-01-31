package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DreamEaterStatus;

public class Combustibility extends status{
	
	public static String name = "Combustible";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Schmuck inflicter;
	int damageSaved;
	int turnsLeft;
	public Combustibility(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.inflicter = perp;
		this.damageSaved = 0;
		this.turnsLeft = i;
	}
	
	public Combustibility(int pr){
		super(name, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){	
		damageSaved += damage;	
		return damage;
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(turnsLeft <=0 ){
			if(damageSaved < 0){
				bs.bp.bt.addScene(s.getName()+"'s Combustibility ignites destructively!");
			}
			else{
				bs.bp.bt.addScene(s.getName()+"'s Combustibility ignites comfortingly!");
			}
			bs.bp.em.hpChange(damageSaved * inflicter.getRedPoints()/100, inflicter, s, 0);
		}
		else{
			turnsLeft--;
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Combustible!";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Combustibilty faded!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
