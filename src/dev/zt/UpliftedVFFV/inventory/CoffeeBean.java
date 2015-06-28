package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class CoffeeBean extends Item{

	static String descr="A fragrant, roasted coffee bean.";
	static String descrShort="Restore Mp and damage.";
	public CoffeeBean() {
		super(2, "Roasted Coffee Bean",true,  true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" pops the Coffee bean into his/her mouth.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Coffee Bean.");
		}
		bs.bp.bt.textList.add("The Coffee Bean scalds "+vic.getName()+"'s tongue.");
		bs.bp.em.hpChange(-10,perp,vic);
		bs.bp.em.bpChange(30,vic);

	}
	
	public void use(Schmuck s){
		s.hpChange(-10);
		s.bpChange(30);
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
