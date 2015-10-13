package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Asleep extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Asleep(int i, Schmuck perp, int pr){
		super(i, "Asleep", false, true, false, perp, pr);
	}
	
	public Asleep(Schmuck perp, int pr){
		super("Asleep", true, false, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is still Asleep!"),bs));
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.stm.removeStatus(vic, new Asleep(vic,0));
		bs.bp.bt.textList.add(vic.getName()+" was startled awake!");
		return damage;
	}	

	public String inflictText(Schmuck s){
		return s.getName()+" fell Asleep!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" woke up!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
