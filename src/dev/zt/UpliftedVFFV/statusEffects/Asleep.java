package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DreamEaterStatus;

public class Asleep extends status{
	
	public static String name = "Asleep";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Asleep(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Asleep(int pr){
		super(name, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is still Asleep!"),bs));
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(!bs.bp.stm.checkStatus(perp, new DreamEaterStatus(0))){
			bs.bp.stm.removeStatus(vic, new Asleep(0));
			bs.bp.bt.textList.add(vic.getName()+" was startled awake!");
		}
		else{
			bs.bp.bt.textList.add(vic.getName()+" tosses and turns in "+vic.getPronoun(1)+" sleep, but cannot wake.");
		}
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
