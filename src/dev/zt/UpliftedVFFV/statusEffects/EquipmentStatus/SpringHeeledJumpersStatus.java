package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SpringHeeledJumpersStatus extends status{
	
	public static String name = "Springy";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public boolean powdef;
	public int counter;
	public SpringHeeledJumpersStatus(Schmuck v,int pr){
		super(name,v, pr);
		this.powdef = true;
		this.counter = 0;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		powdef = true;
	}
	
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){//
		powdef = true;
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(powdef){
			bs.bp.bt.addScene(s.getName()+" pounces with+"+s.getPronoun(1)+" Spring-Heels!");
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
			bs.bp.bt.addScene(s.getName()+"'s Spring-Heels coil back up defensively!");
			powdef = true;
		}
		if(counter > 0 && !powdef){
			counter--;
		}
	}
}
