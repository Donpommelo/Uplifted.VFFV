package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.Animations.PoisonAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Bleed extends status{
	
	public static String name = "Bleed";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Bleed(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
	}
	
	public Bleed(Schmuck v,int pr){
		super(name, v,pr);
	}
		
	public void onActionUser(BattleState bs, Action a){
		if(a.getSkill().getName() != "Pass Turn"){
			bs.bp.bt.addScene(a.getUser().getName()+" continues to bleed!", new PoisonAnim(a.getUser()),this, false);
		}
	}
	
	public void postAnimRun(BattleState bs){
		bs.bp.em.hpChange(-(vic.getMaxHp()/5),inflicter,vic,6);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" began Bleeding!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Bleeding stopped!";
	}
		
	public Boolean isBad(){
		return true;
	}
}
