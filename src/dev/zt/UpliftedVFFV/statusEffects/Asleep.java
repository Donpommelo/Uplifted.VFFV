package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DreamEaterStatus;

public class Asleep extends status{
	
	public static String name = "Sleep";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	int wakeThreshold;
	public Asleep(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
		this.wakeThreshold = 0;
	}
	
	public Asleep(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is still Asleep!"),bs));
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(!bs.bp.stm.checkStatus(perp, new DreamEaterStatus(0))){
			wakeThreshold -= damage;
			if(wakeThreshold >= vic.getMaxHp()/10+inflicter.getPurplePoints()){
				bs.bp.stm.removeStatus(vic, new Asleep(0));
				bs.bp.bt.addScene(vic.getName()+" was startled awake!");
			}
		}
		else{
			bs.bp.bt.addScene(vic.getName()+" tosses and turns in "+vic.getPronoun(1)+" sleep, but cannot wake.");
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
	
	public Boolean isDisable(){
		return true;
	}
}
