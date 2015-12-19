package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LemonyFresh extends Item{

	static int id = 2;
	static String name = "Lemony Fresh";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 24;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A can of translucent liquid. It is either the tastiest detergent or the\nmost antiseptic energy drink on the market.";
	static String descrShort="Restore Hp and Bp and\nshorten statuses.";
	public LemonyFresh() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the bottle of Lemony Fresh.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Lemony Fresh.");
		}
		bs.bp.em.hpChange((int)(15*(1+perp.getItemPow())), perp, vic,6);
		bs.bp.em.bpChange((int)(15*(1+perp.getItemPow())),vic);
		for(status s: vic.statuses){
			if(!s.perm){
				s.setDuration(s.getDuration()/2);
			}
		}
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(25*(1+s.getItemPow())));
		s.bpChange((int)(15*(1+s.getItemPow())));
	}
}