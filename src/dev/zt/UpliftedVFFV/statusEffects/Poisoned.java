package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poisoned extends status{
	
	public static String name = "Poison";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck inflicter;
	public Poisoned(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.inflicter = perp;
	}
	
	public Poisoned(int pr){
		super(name, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(inflicter.getGreenPoints() > 120){
			bs.bp.bt.addScene(s.getName()+" takes massive damage from Poison!");
			bs.bp.em.hpChange(-s.getMaxHp()/3,inflicter,s,2);	
		}
		else if(inflicter.getGreenPoints() > 90){
			bs.bp.bt.addScene(s.getName()+" takes heavy damage from Poison!");
			bs.bp.em.hpChange(-s.getMaxHp()/5,inflicter,s,2);	
		}
		else if(inflicter.getGreenPoints() > 50){
			bs.bp.bt.addScene(s.getName()+" takes moderate damage from Poison!");
			bs.bp.em.hpChange(-s.getMaxHp()/8,inflicter,s,2);	
		}
		else if(inflicter.getGreenPoints() > 0){
			bs.bp.bt.addScene(s.getName()+" takes light damage from Poison!");
			bs.bp.em.hpChange(-s.getMaxHp()/10,inflicter,s,2);	
		}
		else{
			bs.bp.bt.addScene(s.getName()+" draws vitality from Poison!");
			bs.bp.em.hpChange(-inflicter.getGreenPoints(),inflicter,s,2);	
		}
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
