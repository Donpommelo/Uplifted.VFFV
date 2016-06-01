package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.Animations.PoisonAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RedTideTalismanStatus;

public class Poisoned extends status{
	
	public static String name = "Poison";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Poisoned(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
	}
	
	public Poisoned(Schmuck v,int pr){
		super(name, v,pr);
	}
		
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		bs.bp.bt.addScene("", new PoisonAnim(s),this, false);
	}

	public void postAnimRun(BattleState bs){
		if(bs.bp.stm.checkStatus(inflicter, new RedTideTalismanStatus(inflicter,50))){
			bs.bp.em.hpChange(-(vic.getMaxHp()/100+inflicter.getGreenPoints()/2),inflicter,vic,0);
		}
		else{
			bs.bp.em.hpChange(-(vic.getMaxHp()/100+inflicter.getGreenPoints()/2),inflicter,vic,2);
		}
	}
	
	public int getFrames(){
		return 0;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was Poisoned!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" was cured of Poison!";
	}
	
	public int stackingEffect(){
		return 1;
	}
	
	public Boolean isBad(){
		return true;
	}
}
