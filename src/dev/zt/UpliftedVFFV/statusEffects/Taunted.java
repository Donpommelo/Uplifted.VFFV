package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Taunted extends status{
	
	public static String name = "Taunt";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck Taunter;
	public Taunted(int i, Schmuck perp, Schmuck vic, Schmuck taunter, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.Taunter = taunter;
	}
	
	public Taunted(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.getTarget() != Taunter && a.getSkill().getTargetType() ==0){
			bs.bp.bt.addScene(s.getName()+" is being Taunted by "+Taunter.getName()+"!");
			a.setTarget(Taunter);
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Taunted by "+Taunter.getName()+"!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Taunted!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
