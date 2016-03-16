package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Paralysis extends status{
	
	public static String name = "Paralysis";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Paralysis(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
	}
	
	public Paralysis(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		double stunchance = 0;
		if(inflicter.getYellowPoints() > 100){
			stunchance = 1;	
		}
		else if(inflicter.getYellowPoints() > 90){
			stunchance = .80;
		}
		else if(inflicter.getYellowPoints() > 50){
			stunchance = .60;
	
		}
		else if(inflicter.getYellowPoints() > 0){
			stunchance = .40;
		}
		else{
			stunchance = .20;	
		}
		if(Math.random() <= stunchance){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s Paralysis prevents action!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Paralyzed and may be unable to move!.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" recovered from Paralysis.";
	}
	
	public Boolean isDisable(){
		return true;
	}
	
	public Boolean isBad(){
		return true;
	}
}
