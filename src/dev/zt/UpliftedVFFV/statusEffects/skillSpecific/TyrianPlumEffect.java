package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class TyrianPlumEffect extends status{
	
	public static String name = "Plum Outta Luck";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public TyrianPlumEffect(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public void onAction(BattleState bs, Action a){
		int amount = a.skill.getCost();
		if(amount!=0){
			if(!bs.bp.stm.checkStatus(perp,  new incapacitate(perp))){
				bs.bp.bt.textList.add(perp.getName()+"'s Tyrian Plum drains health");
				bs.bp.em.hpChange((int)(amount*1.5*(1+perp.getHealPower())), perp, perp,2);
			}
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" has seeds growing inside.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s seeds passed away.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
