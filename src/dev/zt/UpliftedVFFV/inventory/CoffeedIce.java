package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class CoffeedIce extends Item{

	static String descr="A thermos of shaved ice with some faint coffee flavoring.";
	static String descrShort="Restore Hp and Mp.";
	public CoffeedIce() {
		super(2, "Coffee'd Ice",true,  true, true, true,descr, descrShort, 22, 0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Coffee'd Ice.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" Coffee'd Ice.");
		}
//		bs.bp.stm.removeStatus(vic, );
		bs.bp.em.hpChange((int)(15*(1+perp.getItemPow())),perp, vic,6);
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())),vic);
	}
	
	public void use(Schmuck s){
		s.hpChange((int)(25*(1+s.getItemPow())));
		s.bpChange((int)(35*(1+s.getItemPow())));
	}

}
