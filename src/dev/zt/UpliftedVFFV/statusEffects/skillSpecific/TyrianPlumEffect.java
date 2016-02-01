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
		if(!bs.bp.stm.checkStatus(perp,  new incapacitate(perp))){
			bs.bp.bt.addScene(perp.getName()+"'s Tyrian Plum drains health");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, a.getUser())* 0.2);
			bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,2);
			bs.bp.em.hpChange(damage, a.getUser(), perp,2);
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
