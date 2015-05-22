package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;

public class BeefBoyle extends Item{
	
	static String descr="A thick, stew filled with beef as well as several ingredients that are \nless likely to be beef. ";
	public BeefBoyle() {
		super(2, "Beef Boyleston", false, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" chokes down the Bef Boyleston!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Beef Boyleston.");
		}
		bs.bp.stm.addStatus(vic, new BeefedUp(5,bs));
	}

}
