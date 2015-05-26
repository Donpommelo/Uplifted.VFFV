package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class CoffeedIce extends Item{

	static String descr="A thermos of shaved ice with some faint coffee flavoring.";
	static String descrShort="Restore Hp and Mp.";
	public CoffeedIce() {
		super(2, "Coffee'd Ice",true,  true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" drinks the Coffee'd Ice.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" Coffee'd Ice.");
		}
//		bs.bp.stm.removeStatus(vic, );
		bs.bp.em.hpChange(15,vic);
		bs.bp.em.bpChange(25,vic);
	}
	
	public void use(Schmuck s){
		s.hpChange(25);
		s.bpChange(35);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
