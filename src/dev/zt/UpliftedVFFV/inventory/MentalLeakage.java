package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MentalLeakage extends Item{

	static String descr="A handful of loose thoughts. You doubt it contains anything useful.";
	static String descrShort="Restore Mp.";
	public MentalLeakage() {
		super(2, "Mental Leakage",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" consumes the Mental Leakage.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" uses the Mental Leakage on "+vic.getName());
		}
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())),vic);
		if(Math.random()<.1){
			//get some terrible side effect.
		}
	}
	
	public void use(Schmuck s){
		s.bpChange((int)(30*(1+s.getItemPow())));
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
