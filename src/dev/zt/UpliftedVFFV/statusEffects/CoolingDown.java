package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CoolingDown extends status{
	
	public int turnsLeft;
	public static String name = "Cooldown";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public CoolingDown(int cd, Schmuck perp, Schmuck vic,  int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.turnsLeft = cd;
	}

	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(turnsLeft <= (int)(0+s.getCooldownBonus())){
			bs.bp.bt.addScene(s.getName()+" is done cooling down!");
			bs.bp.stm.hardRemoveStatus(s, this);
		}
		else{
			turnsLeft--;
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" needs to Cool Down.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is done Cooling Down.";
	}
	
	public int stackingEffect(){
		return 1;
	}
	
}
