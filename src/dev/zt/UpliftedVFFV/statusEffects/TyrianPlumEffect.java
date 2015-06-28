package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TyrianPlumEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public TyrianPlumEffect(int i, Schmuck perp){
		super(i, "Plum Outta Luck", false, true, true, perp);
	}
	
	public void onAction(BattleState bs, Action a){
		int amount = a.skill.getCost();
		if(amount!=0){
			bs.bp.bt.textList.add(a.user.getName()+"'s Tyrian Plum drains health");
			if(amount*1.5>=a.user.getCurrentHp()){
				a.user.setCurrentHp(1);
			}
			else{
				bs.bp.em.hpChange(-(int)(amount*1.5),perp, a.user, 2);
			}
			bs.bp.em.hpChange((int)(amount*1.5), a.user, perp);
		}
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" has seeds growing inside.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s seeds passed away.";
	}
	
	public int getDuration(){
		return duration;
	}

}
