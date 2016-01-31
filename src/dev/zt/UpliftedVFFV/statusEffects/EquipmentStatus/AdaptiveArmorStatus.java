package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AdaptiveArmorStatus extends status{
	
	public static String name = "Adaptive";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public boolean powdef;
	public int counter;
	public AdaptiveArmorStatus(int pr){
		super(name, pr);
		this.powdef = true;
		this.counter = 0;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		powdef = true;
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(powdef){
			bs.bp.bt.addScene(s.getName()+"'s Adaptive Armor shifts into Attack mode!");
			powdef = false;
			counter = 3;
		}
	}
	
	public void statchanges(Schmuck s){
		int points = (s.getBuffedPow()+s.getBuffedDef())/4;
		if(powdef){
			s.setBuffedPow(s.getBuffedPow() - points);
			s.setBuffedDef(s.getBuffedDef() + points);
		}
		else{
			s.setBuffedPow(s.getBuffedPow() + points);
			s.setBuffedDef(s.getBuffedDef() - points);
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(counter == 0 && !powdef){
			bs.bp.bt.addScene(s.getName()+"'s Adaptive Armor shifts into Defense mode!");
			powdef = true;
		}
		if(counter > 0 && !powdef){
			counter--;
		}
	}
}
