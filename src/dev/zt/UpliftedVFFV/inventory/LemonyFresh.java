package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LemonyFresh extends Item{

	static String descr="A can of translucent liquid. It is either the tastiest detergent or the\nmost antiseptic energy drink on the market.";
	static String descrShort="Restore Hp and Bp and\nshorten statuses.";
	public LemonyFresh() {
		super(2, "Lemony Fresh",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the bottle of Lemony Fresh.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Lemony Fresh.");
		}
		bs.bp.em.hpChange(15, perp, vic);
		bs.bp.em.bpChange(15,vic);
		for(status s: vic.statuses){
			if(!s.perm){
				s.setDuration(s.getDuration()/2);
			}
		}
	}
	
	public void use(Schmuck s){
		s.hpChange(15);
		s.bpChange(15);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
